package com.shyms.corpormobile.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.IBinder;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ken on 20/7/15.
 */
public class Util {
    /**
     * method is used for checking valid email id format.
     *
     * @param email
     * @return boolean true for valid false for invalid
     */
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }

    /**
     * http://jingyan.baidu.com/article/a3761b2b8683341576f9aaaf.html
     *
     * @param mobiles
     * @return
     */
    public static boolean isMobileNO(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

    public static boolean isMobileNONew(String mobile) {
        Pattern p = Pattern.compile("^(0|86|17951)?(13[0-9]|15[012356789]|17[0-9]|18[0-9]|14[57])[0-9]{8}$");
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

//    public static void loadImage(String url, ImageView image) {
//        loadImageWithPlaceHolder(url, image, R.drawable.welcome);
//    }
//
//    public static void loadImageNoPlaceHolder(String url, ImageView image) {
//        Picasso.with(KinkApplication.context).load(url).into(image);
//    }
//
//    public static void loadImageWithPlaceHolder(String url,
//                                                ImageView image,
//                                                @DrawableRes int placeHolderRes) {
//        Picasso.with(KinkApplication.context).load(url).placeholder(placeHolderRes).into(image);
//    }
//
//    public static void loadLocalImage(String url, ImageView image) {
//        Picasso.with(KinkApplication.context).load("file://" + url).into(image);
//    }

    /**
     * @param context
     * @param windowToken can be getted by calling EditView.getWindowToken()
     */
    public static void hideKeyBoard(Context context, IBinder windowToken) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(windowToken, 0);
    }

    /**
     * @param context
     * @param
     */
    public static void showKeyBoard(Context context) {
        InputMethodManager imm = (InputMethodManager) context.
                getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static String formatFansNumString(long fansNum) {
        if (fansNum < 10000) {
            return String.valueOf(fansNum);
        } else if (fansNum >= 10000 && fansNum < 1000000) {
            return String.valueOf(fansNum / 10000) + "万";
        } else {
            return String.valueOf((int) (fansNum / 10000)) + "万";
        }
    }

    /**
     * @param timeStamp seconds
     * @return
     */
    public static String formatTimeString(long timeStamp) {
        long now = System.currentTimeMillis();
        long interval = now - timeStamp * 1000;
        interval = Math.max(0, interval);
        if (interval < 1000 * 60) {
            return String.valueOf(interval / 1000) + "秒前";
        } else if (interval < 1000 * 60 * 60) {
            return String.valueOf(interval / (1000 * 60)) + "分钟前";
        } else if (interval < 1000 * 60 * 60 * 24) {
            return String.valueOf(interval / (1000 * 60 * 60)) + "小时前";
        } else if (interval < 1000 * 60 * 60 * 24 * 10) {//10 day
            return String.valueOf(interval / (1000 * 60 * 60 * 24)) + "天前";
        }


        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(new Date(timeStamp * 1000));
    }


    public static String formatTimeString(long timeStamp, boolean IsshowShortDate) {
        long now = System.currentTimeMillis();
        long interval = now - timeStamp * 1000;
        interval = Math.max(0, interval);
        if (interval < 1000 * 60) {
            return String.valueOf(interval / 1000) + "秒前";
        } else if (interval < 1000 * 60 * 60) {
            return String.valueOf(interval / (1000 * 60)) + "分钟前";
        } else if (interval < 1000 * 60 * 60 * 24) {
            return String.valueOf(interval / (1000 * 60 * 60)) + "小时前";
        } else if (interval < 1000 * 60 * 60 * 24 * 10) {//10 day
            return String.valueOf(interval / (1000 * 60 * 60 * 24)) + "天前";
        }
        SimpleDateFormat format = null;
        if (!IsshowShortDate)
            format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        else
            format = new SimpleDateFormat("MM-dd");
        return format.format(new Date(timeStamp * 1000));
    }




    public static int calculateInSampleSize(BitmapFactory.Options options,
                                            int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 1;

        if (height > reqHeight || width > reqWidth) {

            // Calculate ratios of height and width to requested height and
            // width
            final int heightRatio = Math.round((float) height
                    / (float) reqHeight);
            final int widthRatio = Math.round((float) width / (float) reqWidth);

            // Choose the smallest ratio as inSampleSize value, this will
            // guarantee
            // a final image with both dimensions larger than or equal to the
            // requested height and width.
            inSampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
        }

        return inSampleSize;
    }

    public static Bitmap getSmallBitmap(String filePath) {
        final BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filePath, options);

        // Calculate inSampleSize
//        options.inSampleSize = calculateInSampleSize(options, 80, 80);

        // Decode bitmap with inSampleSize set
        options.inJustDecodeBounds = false;

        return BitmapFactory.decodeFile(filePath, options);
    }

    public static void pasteToClipBoard(Context context, String content) {
        int sdk = android.os.Build.VERSION.SDK_INT;

        if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
            android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(content);
        } else {
            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", content);
            clipboard.setPrimaryClip(clip);
        }
    }

//    public static void handleNetError(Context context, Throwable throwable) {
//        if (NErrorMessArr.getStatuCode((RetrofitError) throwable) == 400) {
//            context.startActivity(new Intent(context, LoginActivity.class));
//        } else {
//            ToastUtil.shortShowText(NErrorMessArr.handleError((RetrofitError) throwable));
//        }
//    }

    /**
     * @param s
     * @return
     */
    public static int getLength(String s) {
        if (TextUtils.isEmpty(s)) {
            return 0;
        }
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 2;
            } else {
                // 其他字符长度为0.5
                valueLength += 1;
            }
        }
        //进位取整
        return valueLength;
    }

    public static int getChineseCharacterCount(String s) {
        int valueLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 1;
            }
        }
        //进位取整
        return valueLength;
    }

//    public static String getEmojiString(String s, int len) {
//        len = 2 * len;
//        int valueLength = 0;
//        int realLength = 0;
//        String chinese = "[\u4e00-\u9fa5]";
//        for (int i = 0; i < s.length(); i++) {
//            if (valueLength >= len) {
//                break;
//            }
//            // 获取一个字符
//            if (s.charAt(i) == '[') {
//                for (int k = 0; k < ExtendEmojiconHandler.sEmojiStr.length; k++) {
//                    String emoji = ExtendEmojiconHandler.sEmojiStr[k];
//                    if (emoji.equals(s.substring(i, i + emoji.length()))) {
//                        valueLength += 2;
//                        realLength += emoji.length();
//                        i += emoji.length();
//                        break;
//                    }
//                }
//            }
//            if (i >= s.length()) {
//                break;
//            }
//            String temp = s.substring(i, i + 1);
//            // 判断是否为中文字符
//            if (temp.matches(chinese)) {
//                // 中文字符长度为1
//                valueLength += 2;
//                realLength += 1;
//            } else {
//                // 其他字符长度为0.5
//                valueLength += 1;
//                realLength += 1;
//            }
//        }
//        return s.substring(0, realLength);
//    }


    //截取字符串最大长度(一个长度表示一个汉字,其他表示半个)
    public static String getString(String s, int len) {
        len = 2 * len;
        int valueLength = 0;
        int realLength = 0;
        String chinese = "[\u4e00-\u9fa5]";
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < s.length(); i++) {
            if (valueLength >= len) {
                break;
            }
            // 获取一个字符
            String temp = s.substring(i, i + 1);
            // 判断是否为中文字符
            if (temp.matches(chinese)) {
                // 中文字符长度为1
                valueLength += 2;
                realLength += 1;
            } else {
                // 其他字符长度为0.5
                valueLength += 1;
                realLength += 1;
            }
        }
        //进位取整
        return s.substring(0, realLength);


    }

    //处理选项文字长度
    public static void handleChoiceLength(final EditText input, int maxLength) {
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                //剩余字数(以汉字为准)

                int remain = maxLength - Util.getLength(input.getText().toString()) / 2;
                if (remain < 0) {
                    String text = input.getText().toString();
                    //截取字段
                    input.setText(Util.getString(text, maxLength));
                    input.setSelection(input.getText().toString().length());
                    ToastUtil.shortShowText("最多" + maxLength + "个字");
                }
            }
        });
    }
}
