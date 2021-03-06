/**
 * Designed and developed by Aidan Follestad (@afollestad)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.afollestad.materialdialogs.utils

import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.AttrRes
import androidx.annotation.CheckResult
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.RestrictTo
import androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.R
import com.afollestad.materialdialogs.utils.MDUtil.resolveColor

@ColorInt @CheckResult
internal fun MaterialDialog.resolveColor(
  @ColorRes res: Int? = null,
  @AttrRes attr: Int? = null
): Int = resolveColor(windowContext, res, attr)

@ColorInt @CheckResult
internal fun Int.adjustAlpha(alpha: Float): Int {
  val newAlpha = (255 * alpha).toInt()
  return Color.argb(newAlpha, Color.red(this), Color.green(this), Color.blue(this))
}

@RestrictTo(LIBRARY_GROUP) internal fun MaterialDialog.createColorSelector(
  @ColorInt unchecked: Int = resolveColor(windowContext, attr = R.attr.colorControlNormal),
  @ColorInt checked: Int = resolveColor(windowContext, attr = R.attr.colorControlActivated)
): ColorStateList {
  return ColorStateList(
      arrayOf(
          intArrayOf(-android.R.attr.state_checked),
          intArrayOf(android.R.attr.state_checked)
      ),
      intArrayOf(unchecked, checked)
  )
}
