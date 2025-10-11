package com.example.cupcake.test

import androidx.activity.ComponentActivity
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.cupcake.data.DataSource
import com.example.cupcake.data.OrderUiState
import com.example.cupcake.ui.OrderSummaryScreen
import com.example.cupcake.ui.SelectOptionScreen
import com.example.cupcake.ui.StartOrderScreen
import org.junit.Rule
import org.junit.Test

class CupcakeOrderScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<ComponentActivity>()


    private val fakeOrderUiState = OrderUiState(
        quantity = 4,
        flavor = "Coffee",
        date = "Mon Jul 30",
        price = "$200",
        pickupOptions = listOf()
    )
    @Test
    fun selectOptionScreen_verifyContent() {
        val flavors = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")

        val subtotal = "$100"
        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subtotal, options = flavors)
        }

        flavors.forEach { flavor ->
            composeTestRule.onNodeWithText(flavor).assertIsDisplayed()
        }

        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                com.example.cupcake.R.string.subtotal_price,
                subtotal
            )
        ).assertIsDisplayed()

        composeTestRule.onNodeWithStringId(com.example.cupcake.R.string.next).assertIsNotEnabled()
    }

    @Test
    fun selectStartScreen_verifyContent() {
        val cupcakeImageContent = "cupcake_img"
        val orderCupcakeText = com.example.cupcake.R.string.order_cupcakes
        val buttons = DataSource.quantityOptions
        composeTestRule.setContent {
            StartOrderScreen(buttons, {})
        }

        buttons.forEach {
            composeTestRule.onNodeWithStringId(it.first).assertIsDisplayed()
        }

        composeTestRule.onNodeWithStringId(orderCupcakeText).assertIsDisplayed()
        composeTestRule.onAllNodesWithContentDescription(cupcakeImageContent)
    }

    @Test
    fun selectSummaryScreen_verifyContent() {
        composeTestRule.setContent {
            OrderSummaryScreen(
                orderUiState = fakeOrderUiState,
                onCancelButtonClicked = {},
                onSendButtonClicked = { _, _ -> },
            )
        }

        composeTestRule.onNodeWithText(fakeOrderUiState.flavor).assertIsDisplayed()
        composeTestRule.onNodeWithText(fakeOrderUiState.date).assertIsDisplayed()
        composeTestRule.onNodeWithText(
            composeTestRule.activity.getString(
                com.example.cupcake.R.string.subtotal_price,
                fakeOrderUiState.price
            )
        ).assertIsDisplayed()
    }

    @Test
    fun selectOptionScreen_optionSelected_NextButtonEnabled() {
        val flavours = listOf("Vanilla", "Chocolate", "Hazelnut", "Cookie", "Mango")

        val subTotal = "$34"

        composeTestRule.setContent {
            SelectOptionScreen(subtotal = subTotal, options = flavours)
        }

        composeTestRule.onNodeWithText("Vanilla").performClick()

        composeTestRule.onNodeWithStringId(com.example.cupcake.R.string.next).assertIsEnabled()
    }
}