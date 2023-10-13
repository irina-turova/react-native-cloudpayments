package com.reactnativecloudpayments

import com.facebook.react.bridge.ReadableMap
import com.fasterxml.jackson.databind.ObjectMapper
import ru.cloudpayments.sdk.api.models.PaymentDataPayer

// Класс для хранения payment data

data class InitialPaymentData(var paymentData: ReadableMap, val jsonDataString: String?) {
  var publicId: String = paymentData.getString("publicId") as String;
  var accountId: String? = paymentData.getString("accountId");
  var description: String? = paymentData.getString("description");
  var ipAddress: String? = paymentData.getString("ipAddress");
  var invoiceId: String? = paymentData.getString("invoiceId");
  var cardHolderName: String? = paymentData.getString("cardHolderName");
  var yandexPayMerchantID: String? = paymentData.getString("yandexPayMerchantID");
  var cultureName: String? = paymentData.getString("cultureName");
  var payer: PaymentDataPayer? = paymentData.getMap("payer")?.let { loadPaymentDataPayer(it) }

  lateinit var totalAmount: String
  lateinit var currency: String
}


fun loadPaymentDataPayer(paymentDataPayer: ReadableMap): PaymentDataPayer {
  return PaymentDataPayer(
    firstName = paymentDataPayer.getString("firstName"),
    lastName = paymentDataPayer.getString("lastName"),
  )
}
