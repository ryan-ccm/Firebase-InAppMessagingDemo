package com.google.firebase.fiamquickstart.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.fiamquickstart.R
import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.inappmessaging.FirebaseInAppMessaging
import kotlinx.android.synthetic.main.activity_main.*

class KotlinMainActivity : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var firebaseIam: FirebaseInAppMessaging

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)
        firebaseIam = FirebaseInAppMessaging.getInstance()

        firebaseIam.isAutomaticDataCollectionEnabled = true
        firebaseIam.setMessagesSuppressed(false)

//        eventTriggerButton.setOnClickListener { view ->
//            firebaseAnalytics.logEvent("engagement_party", Bundle())
//            Snackbar.make(view, "'engagement_party' event triggered!", Snackbar.LENGTH_LONG)
//                    .setAction("Action", null)
//                    .show()
//        }
        FirebaseInAppMessaging.getInstance().triggerEvent("view_sale")

        // Get and display/log the Instance ID
        FirebaseInstanceId.getInstance().instanceId
                .addOnSuccessListener { instanceIdResult ->
                    val instanceId = instanceIdResult.id
                    instanceIdText.text = getString(R.string.instance_id_fmt, instanceId)
                    Log.d(TAG, "InstanceId: $instanceId")
                }
    }

    companion object {

        private const val TAG = "FIAM-Quickstart"
    }
}
