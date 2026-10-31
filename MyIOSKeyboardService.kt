package com.example.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button

class MyIOSKeyboardService : InputMethodService() {

    override fun onCreateInputView(): View {
        // ربط تصميم الكيبورد العريض والطويل الذي أنشأناه
        val view = layoutInflater.inflate(R.layout.keyboard_view, null)

        // زر المسافة المخصص الذي يكتب الرمز ~
        val btnSpaceTilde = view.findViewById<Button>(R.id.btn_space_tilde)
        btnSpaceTilde?.setOnClickListener {
            currentInputConnection?.commitText("~", 1)
        }

        // زر الحذف ⌫
        val btnDelete = view.findViewById<Button>(R.id.btn_delete)
        btnDelete?.setOnClickListener {
            currentInputConnection?.deleteSurroundingText(1, 0)
        }

        // ربط بعض الحروف الأساسية كمثال (يمكنك توسيعها لاحقاً)
        val btnQ = view.findViewById<Button>(R.id.btn_q)
        btnQ?.setOnClickListener {
            currentInputConnection?.commitText("ض", 1)
        }

        val btnW = view.findViewById<Button>(R.id.btn_w)
        btnW?.setOnClickListener {
            currentInputConnection?.commitText("ص", 1)
        }

        return view
    }
}
