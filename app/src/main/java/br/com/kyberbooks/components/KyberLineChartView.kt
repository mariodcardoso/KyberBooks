package br.com.kyberbooks.components

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import br.com.kyberbooks.R

class KyberLineChartView @JvmOverloads constructor(
    context: Context,
    attrSet: AttributeSet
) : View(context, attrSet) {

    private val dataSet = mutableListOf<DataPoint>()
    private var xMin = 0
    private var xMax = 0
    private var yMin = 0
    private var yMax = 0

    private val dataPointPaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.purple_700)
        strokeWidth = 7f
    }

    private val dataPointLinePaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.purple_300)
        strokeWidth = 7f
        isAntiAlias = true
    }

    private val axisLinePaint = Paint().apply {
        color = ContextCompat.getColor(context, R.color.purple_700)
        strokeWidth = 10f
    }

    fun setData(newDataSet: List<DataPoint>) {
        xMin = newDataSet.minByOrNull { it.xVal }?.xVal ?: 0
        xMax = newDataSet.maxByOrNull { it.xVal }?.xVal ?: 0
        yMin = newDataSet.minByOrNull { it.yVal }?.yVal ?: 0
        yMax = newDataSet.maxByOrNull { it.yVal }?.yVal ?: 0
        dataSet.clear()
        dataSet.addAll(newDataSet)
        invalidate()
    }

    private fun Int.toRealX() = this.toFloat() / (xMax + 1) * width
    private fun Int.toRealY() = ((yMax - this.toFloat()) / yMax * height)

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //Axis Y
        canvas.drawLine(0f, 0f, 0f, height.toFloat(), axisLinePaint)

        //Axis X
        canvas.drawLine(0f, height.toFloat(), width.toFloat(), height.toFloat(), axisLinePaint)

        dataSet.forEachIndexed { index, dataPoint ->
            val realX = dataPoint.xVal.toRealX()
            val realY = dataPoint.yVal.toRealY()

            if (index < dataSet.size - 1) {
                val nextDataPoint = dataSet[index + 1]
                val startX = dataPoint.xVal.toRealX()
                val startY = dataPoint.yVal.toRealY()
                val endX = nextDataPoint.xVal.toRealX()
                val endY = nextDataPoint.yVal.toRealY()

                canvas.drawLine(startX, startY, endX, endY, dataPointLinePaint)
            }

            canvas.drawCircle(realX, realY, 7f, dataPointPaint)
        }
    }
}

data class DataPoint(
    var xVal: Int,
    val yVal: Int
)