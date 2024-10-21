package com.wan.mybroadcastreceiver

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.wan.mybroadcastreceiver.databinding.ActivitySmsReceiverBinding

class SmsReceiverActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SMS_NO = "extra_sms_no"
        const val EXTRA_SMS_MESSAGE = "extra_sms_message"
    }

    private var binding: ActivitySmsReceiverBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySmsReceiverBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        title = getString(R.string.incoming_message)

        binding?.btnClose?.setOnClickListener {
            finish()
        }

        val senderNo = intent.getStringExtra(EXTRA_SMS_NO)
        val senderMessage = intent.getStringExtra(EXTRA_SMS_MESSAGE)

        binding?.tvFrom?.text = getString(R.string.from, senderNo)
        binding?.tvMessage?.text = senderMessage


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

}