package com.example.infs3605v1.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.infs3605v1.R;

public class CovidActivity extends AppCompatActivity {

    ScrollView covidInfoSv;
    ConstraintLayout covidPane1;
    ConstraintLayout covidPane2;
    ConstraintLayout covidPane3;
    ConstraintLayout covidPane4;
    ConstraintLayout covidPane5;
    ConstraintLayout covidPane6;
    ConstraintLayout covidPane7;
    ConstraintLayout covidPane8;
    ConstraintLayout covidPane9;
    ConstraintLayout covidPane10;
    ConstraintLayout covidPane11;
    LinearLayout covidBottomLayer;
    TextView covidInfoTitle;
    TextView covidInfoBody;

    Uri uri;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_covid);

        covidInfoSv = findViewById(R.id.covidInfoSv);
        covidPane1 = covidInfoSv.findViewById(R.id.covidPane1);
        covidPane2 = covidInfoSv.findViewById(R.id.covidPane2);
        covidPane3 = covidInfoSv.findViewById(R.id.covidPane3);
        covidPane4 = covidInfoSv.findViewById(R.id.covidPane4);
        covidPane5 = covidInfoSv.findViewById(R.id.covidPane5);
        covidPane6 = covidInfoSv.findViewById(R.id.covidPane6);
        covidPane7 = covidInfoSv.findViewById(R.id.covidPane7);
        covidPane8 = covidInfoSv.findViewById(R.id.covidPane8);
        covidPane9 = covidInfoSv.findViewById(R.id.covidPane9);
        covidBottomLayer = covidInfoSv.findViewById(R.id.covidBottomLayer);
        covidPane10 = covidBottomLayer.findViewById(R.id.covidPane10);
        covidPane11 = covidBottomLayer.findViewById(R.id.covidPane11);

        populateCovidInfo(covidPane1,
                "Government assistance for businesses",
                "Find government financial assistance and support your business.");
        populateCovidInfo(covidPane2,
                "State and territory information, grants and assistance",
                "Find the latest coronavirus information, grants and support in your state or territory.");
        populateCovidInfo(covidPane3,
                "Relief for commerical tenants",
                "Read about measures to help renters, including a mandatory code of conduct for commercial tenants.");
        populateCovidInfo(covidPane4,
                "JobKeeper Payment for employers and employees",
                "Under the JobKeeper Payment, businesses impacted by COVID-19 will be able to access a payment to continue paying their employees.");
        populateCovidInfo(covidPane5,
                "JobKeeper Payment for sole traders and other entities",
                "Sole traders and other entities may be eligible to receive the JobKeeper Payment if their turnover has reduced due to coronavirus.");
        populateCovidInfo(covidPane6,
                "Support for sole traders",
                "The Australian Government has announced measures to support businesses impacted by the coronavirus (COVID-19). If you're a sole trader, learn what your business can get and where to go for help.");
        populateCovidInfo(covidPane7,
                "Support available for employers",
                "The Australian Government has announced measures to support businesses impacted by the coronavirus (COVID-19). If you're an employer, learn what your business can get and where to go for help.");
        populateCovidInfo(covidPane8,
                "Support available for companies",
                "The Australian Government has announced measures to support businesses impacted by the coronavirus (COVID-19). If you run a company, learn what your business can get and where to go for help.");
        populateCovidInfo(covidPane9,
                "Restrictions on services",
                "The Australian Government has announced social distancing measures to protect the Australian community from the spread of the coronavirus. Restrictions have been placed on a number of services.");

        covidPane1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/government-assistance-for-business");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/coronavirus-state-and-territory-information-and-assistance");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/relief-for-commercial-tenancies");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/jobkeeper-payment-for-employers-and-employees");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/jobkeeper-payment-for-sole-traders");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/support-for-sole-traders");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/support-available-for-employers");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/support-available-for-companies");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/restrictions-on-non-essential-services");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/risk-management/emergency-management/coronavirus-information-and-support-for-business/business-information");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
        covidPane11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uri = Uri.parse("https://business.gov.au/guide/continuing-your-business");
                intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    private void populateCovidInfo(ConstraintLayout covidInfo, String title, String body){
        covidInfoTitle = covidInfo.findViewById(R.id.covidInfoTitle);
        covidInfoTitle.setText(title);
        covidInfoBody = covidInfo.findViewById(R.id.covidInfoBody);
        covidInfoBody.setText(body);
    }

}
