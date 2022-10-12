package com.ujanglukmanbdg.pemeta.ui.sistempemeta.login.edit

import android.content.Context
import android.graphics.Canvas
import android.graphics.drawable.Drawable
import android.text.Editable
import android.text.TextWatcher
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.ujanglukmanbdg.pemeta.R

class MyPasswordText: AppCompatEditText, View.OnTouchListener {

    private lateinit var keyButtonImage: Drawable

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        showKeyButton()

        textSize = 15f
        textAlignment = View.TEXT_ALIGNMENT_VIEW_START
    }

    private fun init() {
        keyButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_key) as Drawable

        setOnTouchListener(this)

        addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable) {
                if (s.toString().length < 6) {
                    showError()
                }
            }
        })
    }

    override fun onTouch(v: View?, event: MotionEvent): Boolean {
        if (compoundDrawables[2] != null) {

            val keyButtonStart: Float
            val keyButtonEnd: Float
            var isKeyButtonClicked = false

            if (layoutDirection == View.LAYOUT_DIRECTION_RTL) {
                keyButtonEnd = (keyButtonImage.intrinsicWidth + paddingStart).toFloat()
                when {
                    event.x < keyButtonEnd -> isKeyButtonClicked = true
                }
            } else {
                keyButtonStart = (width - paddingEnd - keyButtonImage.intrinsicWidth).toFloat()
                when {
                    event.x > keyButtonStart -> isKeyButtonClicked = true
                }
            }

            if (isKeyButtonClicked) {
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        hideKeyButton()
                        if (transformationMethod.equals(HideReturnsTransformationMethod.getInstance())) {
                            transformationMethod = PasswordTransformationMethod.getInstance()
                            keyButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_key) as Drawable
                            showKeyButton()
                        } else {
                            transformationMethod = HideReturnsTransformationMethod.getInstance()
                            keyButtonImage = ContextCompat.getDrawable(context, R.drawable.ic_key) as Drawable
                            showKeyButton()
                        }
                        return true
                    }
                    else -> return false
                }
            } else return false
        }
        return false
    }

    private fun showKeyButton() {
        setButtonDrawables(endOfTheText = keyButtonImage)
    }

    private fun hideKeyButton() {
        setButtonDrawables()
    }

    private fun setButtonDrawables(
        startOfTheText: Drawable? = null,
        topOfTheText: Drawable? = null,
        endOfTheText: Drawable? = null,
        bottomOfTheText: Drawable? = null
    ) {
        setCompoundDrawablesWithIntrinsicBounds(
            startOfTheText,
            topOfTheText,
            endOfTheText,
            bottomOfTheText
        )
    }

    private fun showError() {
        error = context.getString(R.string.password_invalid)
    }
}