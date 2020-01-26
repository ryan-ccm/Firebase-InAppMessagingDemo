package com.google.firebase.fiamquickstart

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.firebase.example.internal.BaseEntryChoiceActivity
import com.firebase.example.internal.Choice
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.fiamquickstart.java.MainActivity
import com.google.firebase.fiamquickstart.kotlin.KotlinMainActivity
import com.google.firebase.inappmessaging.FirebaseInAppMessaging

class EntryChoiceActivity : BaseEntryChoiceActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var firebaseIam: FirebaseInAppMessaging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        firebaseIam = FirebaseInAppMessaging.getInstance()

        firebaseIam.isAutomaticDataCollectionEnabled = true
        firebaseIam.setMessagesSuppressed(false)

        FirebaseInAppMessaging.getInstance().triggerEvent("view_entry_choice")

        Log.d("EntryChoiceActivity", "event: view_entry_choice")
    }

    override fun getChoices(): List<Choice> {
        return listOf(
                Choice(
                        "Java",
                        "Run the Firebase In App Messaging quickstart written in Java.",
                        Intent(this, MainActivity::class.java)),
                Choice(
                        "Kotlin",
                        "Run the Firebase In App Messaging quickstart written in Kotlin.",
                        Intent(this, KotlinMainActivity::class.java))
        )
    }
}
