package br.com.kyberbooks.components

import android.animation.ValueAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import br.com.kyberbooks.R

class KyberProgressChartView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet,
    attrDefStyle: Int = 0
) : FrameLayout(context, attrSet, attrDefStyle) {

    private val btnSevenDays by lazy { findViewById<KyberButton>(R.id.btn_seven_days) }
    private val btnFifteenDays by lazy { findViewById<KyberButton>(R.id.btn_fifteen_days) }
    private val btnThirtyDays by lazy { findViewById<KyberButton>(R.id.btn_thirty_days) }

    private val lineChart by lazy { findViewById<KyberLineChartView>(R.id.chart_progress) }
    private val bgCourtain by lazy { findViewById<View>(R.id.bg_courtain) }

    val dataPoint = listOf(
        DataPoint(0, 1),
        DataPoint(1, 2),
        DataPoint(2, 0),
        DataPoint(3, 2),
        DataPoint(4, 1),
        DataPoint(5, 5),
        DataPoint(6, 3),
        DataPoint(7, 2),
        DataPoint(8, 1),
        DataPoint(9, 4),
        DataPoint(10, 6),
        DataPoint(11, 1),
        DataPoint(12, 0),
        DataPoint(13, 2),
        DataPoint(14, 1),
        DataPoint(15, 5),
        DataPoint(16, 3),
        DataPoint(17, 2),
        DataPoint(18, 1),
        DataPoint(19, 4),
        DataPoint(20, 6),
        DataPoint(21, 1),
        DataPoint(22, 0),
        DataPoint(23, 2),
        DataPoint(24, 1),
        DataPoint(25, 5),
        DataPoint(26, 3),
        DataPoint(27, 2),
        DataPoint(28, 1),
        DataPoint(29, 4),
        DataPoint(30, 7)
    )

    init {
        View.inflate(context, R.layout.component_progress_chart_view, this)

        setDataInChart(dataPoint)

        btnSevenDays.setOnClickListener {

            val newList = dataPoint.subList(dataPoint.lastIndex - 7, dataPoint.lastIndex)
            newList.forEachIndexed { index, element -> element.xVal = index }

            setDataInChart(newList)
        }

        btnFifteenDays.setOnClickListener {
            val newList = dataPoint.subList(dataPoint.lastIndex - 15, dataPoint.lastIndex)
            newList.forEachIndexed { index, element -> element.xVal = index }

            setDataInChart(newList)
        }

        btnThirtyDays.setOnClickListener {
            val newList = dataPoint.subList(dataPoint.lastIndex - 30, dataPoint.lastIndex)
            newList.forEachIndexed { index, element -> element.xVal = index }

            setDataInChart(newList)
        }
    }

    private fun setDataInChart(dataPoint: List<DataPoint>) {

        lineChart.setData(dataPoint)

        ValueAnimator.ofFloat(0f, 1000f).apply {
            addUpdateListener { bgCourtain.translationX = it.animatedValue as Float }
            duration = 2000
            interpolator = LinearInterpolator()
            start()
        }
    }

}