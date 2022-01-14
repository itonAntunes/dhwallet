package com.digitalhouse.dhwallet.model

import android.widget.ImageView

class GroupCompany (
    val type: GroupCompanyType,
    val title : String? = null,
    val image: String? = null,
    val name: String? = null,
    val contactType: ContactType? = null,
    val description: String? = null,
    val value: String? = null

)

enum class GroupCompanyType{
    TITLE,
    CONTENT,
    PAGAMENTO,
    RECEBIMENTO
}