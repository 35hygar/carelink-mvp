package com.carelink

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_call).setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL).apply {
                data = android.net.Uri.parse("tel:+79991234567")
            }
            startActivity(intent)
        }

        findViewById<Button>(R.id.btn_medicines).setOnClickListener {
            com.carelink.utils.NotificationHelper.showMedicineReminder(this)
            startService(Intent(this, com.carelink.services.FallDetectionService::class.java))
        }

        findViewById<Button>(R.id.btn_sos).setOnLongClickListener {
            startActivity(Intent(this, EmergencyActivity::class.java))
            true
        }
    }
}
