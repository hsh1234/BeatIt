package com.example.homework.screen.personal.main

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import com.example.homework.R
import com.example.homework.base.BaseActivity
import com.example.homework.screen.course.main.CourseActivity
import com.example.homework.screen.file.main.FileActivity
import com.example.homework.screen.personal.aboutus.AboutUsActivity
import com.example.homework.screen.personal.feedbk.FeedBKActivity
import com.example.homework.screen.personal.personalsetting.PersonalSettingActivity
import io.paperdb.Paper
import kotlinx.android.synthetic.main.activity_personal.*
import kotlinx.android.synthetic.main.bar_bottom.*

/**
 * Created by Administrator on 2017/11/9 0009.
 */
class PersonalActivity: BaseActivity(), Contract.View {

    var presenter: Contract.Presenter? = null
    var sid = -1;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal)
        var editor: SharedPreferences.Editor = getSharedPreferences("datap", 0).edit()
        var getEditor = getSharedPreferences("datap", 0)
        presenter!!.setSharedPreferences(getEditor, editor)
        sid  = Paper.book().read("sid")
        setupBottomBar()
        setActionBar()
    }

    override fun onCreatePresenter(presenterFactory: BaseActivity.PresenterFactory) {
        presenter = presenterFactory.createOrGet(PersonalPresenter::class.java)
    }

    override fun getName(name: String) {
        text_personal_name.text = name
    }

    fun setActionBar() {

        btn_personal_personal.setOnClickListener {
            val intent = Intent(this, PersonalSettingActivity::class.java)
            intent.putExtra("sid", sid)
            startActivity(intent)
            finish()
        }

        btn_personal_message.setOnClickListener{
            toast("开发中")
        }

        btn_personal_about.setOnClickListener{
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
        }

        btn_personal_setting.setOnClickListener{
            toast("开发中")
        }

        btn_personal_advice.setOnClickListener{
            val intent = Intent(this, FeedBKActivity::class.java)
            startActivity(intent)
        }

        btn_personal_enteraboutus.setOnClickListener{
            val intent = Intent(this, AboutUsActivity::class.java)
            startActivity(intent)
            toast("开发中")
        }

        btn_personal_enteradvice.setOnClickListener{
            val intent = Intent(this, FeedBKActivity::class.java)
            startActivity(intent)
        }

        btn_personal_entermessage.setOnClickListener{
            toast("开发中")
        }

        btn_personal_entersetting.setOnClickListener{
            toast("开发中")
        }

        btn_personal_alterimg.setOnClickListener {
            toast("开发中")
        }

        btn_personal_enterpersonal.setOnClickListener {
            val intent = Intent(this, PersonalSettingActivity::class.java)
            intent.putExtra("sid", sid)
            startActivity(intent)
            finish()
        }

    }

    fun setupBottomBar(){

        tab_course.setImageResource(R.drawable.icon_bottom_lesson)
        tab_data.setImageResource(R.drawable.icon_bottom_file)
        tab_me.setImageResource(R.drawable.icon_bottom_person_chosen)

        bar_bottom_navigation.setOnClickListener(null)

        tab_data.setOnClickListener {
            startActivity(Intent(this, FileActivity::class.java))
            finish()
        }

        tab_course.setOnClickListener {
            startActivity(Intent(this, CourseActivity::class.java))
            finish()
        }
    }

}
