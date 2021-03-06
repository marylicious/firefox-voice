package mozilla.voice.assistant.intents.communication

import android.content.Context
import android.content.Intent
import androidx.annotation.VisibleForTesting
import mozilla.voice.assistant.intents.Metadata
import mozilla.voice.assistant.intents.ParseResult
import mozilla.voice.assistant.intents.communication.ui.contact.ContactActivity

class PhoneCall {
    companion object {
        @VisibleForTesting
        internal const val NAME_KEY = "name"

        internal fun getIntents() = listOf(
            Pair(
                "call.name",
                ::createPhoneCallIntent
            )
        )

        private fun createPhoneCallIntent(
            pr: ParseResult,
            context: Context?,
            @Suppress("UNUSED_PARAMETER") metadata: Metadata
        ): android.content.Intent? =
            pr.slots[NAME_KEY]?.let { name ->
                Intent(context, ContactActivity::class.java).apply {
                    putExtra(UTTERANCE_KEY, pr.utterance)
                    putExtra(MODE_KEY, VOICE_MODE)
                    putExtra(NICKNAME_KEY, name)
                }
            }
    }
}
