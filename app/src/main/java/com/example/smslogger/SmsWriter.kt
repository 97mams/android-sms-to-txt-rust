object SmsWriter {

    external fun appendSms(text: String, path: String): Int

    fun write(msg: String, context: Context) {
        val file = File(context.filesDir, "sms.txt")
        appendSms(msg, file.absolutePath)
    }

    init {
        System.loadLibrary("sms_rust")
    }
}
