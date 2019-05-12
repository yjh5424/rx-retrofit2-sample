package com.example.exhttp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.HttpException

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        HttpCore.getHttpCore().getSample()
            .subscribeOn(Schedulers.io()) // 순수하게 메인쓰레드가 아닌 다른 쓰레드에서 비동기 처리 도는 네트워크 연결
            .observeOn(AndroidSchedulers.mainThread()) // 다른 T
            .subscribe({
                //
                tv_title.text = it.url
            }, {
                it.printStackTrace()
            })
            // TODO 스케줄러 컨트롤 할 때 진입.
         /*     HttpCore.getHttpCore().getSample()
                  .subscribeOn(Schedulers.newThread())
                  .observeOn(AndroidSchedulers.mainThread())
                  .filter { it ->
                      System.out.println("processing filter1 on thread " + Thread.currentThread().getName())
                      if (it.url?.length > 7) return@filter true else false
                  }
                  .observeOn(Schedulers.newThread())
                  .filter {
                      System.out.println("processing filter2 on thread " + Thread.currentThread().getName())
                      if (it.url?.length > 10) return@filter true else false
                  }
                  .observeOn(AndroidSchedulers.mainThread()) // ui바인딩할 때
                  .subscribe({
                      System.out.println("processing subscribe on thread " + Thread.currentThread().getName())
                      tv_title.text = it.toString()
                      Log.d("test", it.toString())
                  }, {
                      it.printStackTrace()
                  })*/
    }
}
