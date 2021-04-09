package com.example.inspiringpersons.ui

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.inspiringpersons.R

class InspiringPersonsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inspiring_persons)
        setSupportActionBar(findViewById(R.id.toolbar))

    }
}