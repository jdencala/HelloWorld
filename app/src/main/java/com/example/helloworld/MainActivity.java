package com.example.helloworld;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.time.LocalDate;
import java.time.Year;

public class MainActivity extends AppCompatActivity {

    public static final String USERNAME = "loginUsername";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Welcome message
        TextView welcomeTextView = findViewById(R.id.welcome);
        String welcomeMessage = welcomeTextView.getText().toString();
        Bundle extras = getIntent().getExtras();

        String username = extras.getString(USERNAME);
        welcomeMessage = welcomeMessage +  ", " + username;
        welcomeTextView.setText(welcomeMessage);

        //Button
        Button myButton = findViewById(R.id.myButton);
        Button myClear = findViewById(R.id.myClear);
        //EditText
        EditText myEdit = findViewById(R.id.myEdit);
        EditText myName = findViewById(R.id.myName);
        EditText myLastname = findViewById(R.id.myLastname);
        EditText myAge = findViewById(R.id.myAge);
        EditText mySemester= findViewById(R.id.mySemester);
        //TextView
        TextView myTextView = findViewById(R.id.myText);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code is executed when button is clicked
                String degree = String.valueOf(myEdit.getText());
                String name = String.valueOf(myName.getText());
                String lastname = String.valueOf(myLastname.getText());
                String ageString = String.valueOf(myAge.getText());
                String noOfSemester = String.valueOf(mySemester.getText());

                myTextView.setText(buildStudentData(name, lastname, ageString, degree, noOfSemester));
            }
        });

        myClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myEdit.setText("");
                myName.setText("");
                myLastname.setText("");
                myAge.setText("");
                mySemester.setText("");
                myTextView.setText("Student Data UPS");
            }
        });
    }

    public String buildStudentData(String name, String lastname, String age, String degree, String noOfSemester) {
        return "Student Data UPS \n\n" + "Name: "+ name + "\n" +
                "Lastname: " + lastname +"\n" + "Age: " + age + " years\n" +
                "Degree: " + degree  +"\n" + "BirthYear: " + calculateBirthYear(age) + "\n" +
                "EnrollmentYear: " + calculateEnrollmentYear(noOfSemester);
    }

    public String calculateBirthYear(String ageString){
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int age = Integer.parseInt(ageString);
        int birthYear = year - age;
        return String.valueOf(birthYear);
    }

    public String calculateEnrollmentYear(String noOfSemester) {
        LocalDate currentDate = LocalDate.now();
        int year = currentDate.getYear();
        int semester = Integer.parseInt(noOfSemester);
        int years = semester/2;
        int enrollmentYear = year - years;
        return String.valueOf(enrollmentYear);
    }
}