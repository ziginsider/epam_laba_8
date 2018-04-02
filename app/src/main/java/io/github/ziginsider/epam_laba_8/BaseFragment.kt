package io.github.ziginsider.epam_laba_8

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.ziginsider.epam_laba_8.utils.logd

abstract class BaseFragment : Fragment() {

    protected abstract val logTag: String
    protected abstract fun getLayout(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        logd(logTag, "[ ON CREATE ]")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        logd(logTag, "[ ON CREATE VIEW ]")
        return inflater?.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        logd(logTag, "[ ON VIEW CREATED ]")
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        logd(logTag, "[ ON ATTACH ]")
        super.onAttach(context)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        logd(logTag, "[ ON ACTIVITY CREATED ]")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        logd(logTag, "[ ON START ]")
        super.onStart()
    }

    override fun onResume() {
        logd(logTag, "[ ON RESUME ]")
        super.onResume()
    }

    override fun onPause() {
        logd(logTag, "[ ON PAUSE ]")
        super.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        logd(logTag, "[ ON SAVE INSTANCE STATE ]")
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        logd(logTag, "[ ON STOP ]")
        super.onStop()
    }

    override fun onDestroyView() {
        logd(logTag, "[ ON DESTROY VIEW ]")
        super.onDestroyView()
    }

    override fun onDestroy() {
        logd(logTag, "[ ON DESTROY ]")
        super.onDestroy()
    }

    override fun onDetach() {
        logd(logTag, "[ ON DETACH ]")
        super.onDetach()
    }
}