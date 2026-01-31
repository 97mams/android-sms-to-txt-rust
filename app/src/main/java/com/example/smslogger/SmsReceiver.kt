class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras ?: return
        val pdus = bundle["pdus"] as Array<*>

        for (pdu in pdus) {
            val sms = SmsMessage.createFromPdu(pdu as ByteArray)
            val msg =
                "${sms.timestampMillis} | ${sms.originatingAddress}: ${sms.messageBody}\n"

            SmsWriter.write(msg, context)
        }
    }
}
