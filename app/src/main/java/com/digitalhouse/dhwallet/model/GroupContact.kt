package com.digitalhouse.dhwallet.model

import android.widget.ImageView

class GroupContact (
    val type: GroupType,
    val title : String? = null,
    val image: String? = null,
    val name: String? = null,
    val contactType: ContactType? = null,
    val description: String? = null
)

enum class GroupType{
    TITLE,
    CONTENT
}