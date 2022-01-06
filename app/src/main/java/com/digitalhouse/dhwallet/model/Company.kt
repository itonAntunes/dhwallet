package com.digitalhouse.dhwallet.model

import android.os.Parcelable
import android.widget.EditText
import kotlinx.android.parcel.Parcelize

@Parcelize
class Company(
    val image: String,
    val name: String,
    val type: CompanyType,
    val valueCompany: String
): Parcelable

enum class CompanyType(val description: String) {
    PAGAMENTO("Pagamento"),
    RECEBIMENTO("Recebimento"),
}
