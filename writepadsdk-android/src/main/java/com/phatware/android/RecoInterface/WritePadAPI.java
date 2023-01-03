package com.phatware.android.RecoInterface;

import com.phatware.android.WritePadDictionaryEnum;

public class WritePadAPI {
    static {
        System.loadLibrary("WritePadReco");
    }

    public static final int FLAG_SEPLET = 0x00000001;
    public static final int FLAG_USERDICT = 0x00000002;
    public static final int FLAG_MAINDICT = 0x00000004;
    public static final int FLAG_ONLYDICT = 0x00000008;
    public static final int FLAG_STATICSEGMENT = 0x00000010;
    public static final int FLAG_SINGLEWORDONLY = 0x00000020;
    public static final int FLAG_INTERNATIONAL = 0x00000040;
    public static final int FLAG_SUGGESTONLYDICT = 0x00000080;
    public static final int FLAG_ANALYZER = 0x00000100;
    public static final int FLAG_CORRECTOR = 0x00000200;
    public static final int FLAG_SPELLIGNORENUM = 0x00000400;
    public static final int FLAG_SPELLIGNOREUPPER = 0x00000800;
    public static final int FLAG_NOSINGLELETSPACE = 0x00001000;
    public static final int FLAG_ENABLECALC = 0x00002000;
    public static final int FLAG_NOSPACE = 0x00004000;
    public static final int FLAG_ALTDICT = 0x00008000;
    public static final int FLAG_ERROR = 0xFFFFFFFF;

    // gestures
    public static final int GEST_NONE = 0x00000000;
    public static final int GEST_DELETE = 0x00000001;    //
    public static final int GEST_SCROLLUP = 0x00000002;
    public static final int GEST_BACK = 0x00000004;    //
    public static final int GEST_SPACE = 0x00000008;    //
    public static final int GEST_RETURN = 0x00000010;    //
    public static final int GEST_CORRECT = 0x00000020;
    public static final int GEST_SPELL = 0x00000040;
    public static final int GEST_SELECTALL = 0x00000080;
    public static final int GEST_UNDO = 0x00000100;    //
    public static final int GEST_SMALLPT = 0x00000200;
    public static final int GEST_COPY = 0x00000400;
    public static final int GEST_CUT = 0x00000800;
    public static final int GEST_PASTE = 0x00001000;
    public static final int GEST_TAB = 0x00002000;    //
    public static final int GEST_MENU = 0x00004000;
    public static final int GEST_LOOP = 0x00008000;
    public static final int GEST_REDO = 0x00010000;
    public static final int GEST_SCROLLDN = 0x00020000;
    public static final int GEST_SAVE = 0x00040000;
    public static final int GEST_SENDMAIL = 0x00080000;
    public static final int GEST_OPTIONS = 0x00100000;
    public static final int GEST_SENDTODEVICE = 0x00200000;
    public static final int GEST_BACK_LONG = 0x00400000;
    public static final int GEST_LEFTARC = 0x10000000;
    public static final int GEST_RIGHTARC = 0x20000000;
    public static final int GEST_ARCS = 0x30000000;

    public static final int GEST_ALL = 0x0FFFFFFF;

    // language ID
    public static final int LANGUAGE_NONE = 0;
    public static final int LANGUAGE_ENGLISH = 1;
    public static final int LANGUAGE_FRENCH = 2;
    public static final int LANGUAGE_GERMAN = 3;
    public static final int LANGUAGE_SPANISH = 4;
    public static final int LANGUAGE_ITALIAN = 5;
    public static final int LANGUAGE_SWEDISH = 6;
    public static final int LANGUAGE_NORWEGIAN = 7;
    public static final int LANGUAGE_DUTCH = 8;
    public static final int LANGUAGE_DANISH = 9;
    public static final int LANGUAGE_PORTUGUESE = 10;
    public static final int LANGUAGE_PORTUGUESEB = 11;
    public static final int LANGUAGE_MEDICAL = 12;
    public static final int LANGUAGE_FINNISH = 13;
    public static final int LANGUAGE_INDONESIAN = 14;
    public static final int LANGUAGE_ENGLISHUK = 15;

    public static final int HW_MAXWORDLEN = 50;

    public static final int HW_SPELL_CHECK = 0x0000;
    public static final int HW_SPELL_LIST = 0x0001;
    public static final int HW_SPELL_USERDICT = 0x0002;
    public static final int HW_SPELL_USEALTDICT = 0x0004;
    public static final int HW_SPELL_IGNORENUM = 0x0008;
    public static final int HW_SPELL_IGNOREUPPER = 0x0010;

    public static final int MIN_RECOGNITION_WEIGHT = 51;
    public static final int MAX_RECOGNITION_WEIGHT = 100;

    public static final int RECMODE_GENERAL = 0;
    public static final int RECMODE_NUM = 1;
    public static final int RECMODE_CAPITAL = 2;
    public static final int RECMODE_INTERNET = 3;

    //Autocorrector Flags
    public static final int FLAG_IGNORECASE = 0x0001;
    public static final int FLAG_ALWAYS_REPLACE = 0x0002;
    public static final int FLAG_DISABLED = 0x0004;
    public static final String TAG = "WritePadAPI";


    private static native int recognizerInit(String sDir, int languageId, byte[] letterGroupStates, String pUserDict, String pLearner, String pCorrector);

    private static native int getRecognizerFlags();

    private static native void setRecognizerFlags(int flags);

    private static native void freeRecognizer(String pUserDict, String pLearner, String pCorrector);

    public static native boolean reloadAutocorrector();

    private static native boolean reloadUserDict();

    private static native boolean reloadLearner();

    private static native boolean setDictionaryData( byte[] buffer, int flag );

    private static native String recognizeInkData(int nDataLen, boolean bAsync, boolean bFlipY, boolean bSort );

    private static native int stopRecognizer();

    private static native int newStroke(float width, int color);

    private static native int addPixelToStroke(int stroke, float x, float y);

    private static native int getStrokeCount();

    private static native void resetInkData();

    private static native int detectGesture(int type);

    private static native boolean deleteLastStroke();

    private static native boolean isWordInDict(String word, int flags);

    private static native String languageName();

    private static native boolean resetResult();

    private static native int getResultColumnCount();

    private static native int getResultRowCount(int column);

    private static native String getRecognizedWord(int column, int row);

    public boolean recoResetResult() {
        return resetResult();
    }

    public int recoResultColumnCount() {
        return getResultColumnCount();
    }

    public int recoResultRowCount(int column) {
        return getResultRowCount(column);
    }


    public String recoResultWord(int column, int row) {
        return getRecognizedWord(column, row);
    }


    public boolean isDictionaryWord(String word, int flags) {
        return isWordInDict(word, flags);
    }


    public String getLanguageName() {
        return languageName();
    }


    public boolean recoReloadAutocorrector() {
        return reloadAutocorrector();
    }

    public boolean recoReloadUserDict() {
        return reloadUserDict();
    }

    public boolean recoReloadLearner() {
        return reloadLearner();
    }

    public boolean recoSetDict(byte[] buffer) {
        return setDictionaryData(buffer, 0 );
    }


    public int recoGesture(int type) {
        return detectGesture(type);
    }

    public boolean recoDeleteLastStroke() {
        return deleteLastStroke();
    }

    public int recoStrokeCount() {
        return getStrokeCount();
    }

    public int recoAddPixel(int stroke, float x, float y) {
        return addPixelToStroke(stroke, x, y);
    }

    public void recoResetInk() {
        resetInkData();
    }

    public int recoNewStroke(float width, int color) {
        return newStroke(width, color);
    }

    public int recoGetFlags() {
        return getRecognizerFlags();
    }

    public void recoSetFlags(int flags) {
        setRecognizerFlags(flags);
    }

    public int recoStop() {
        return stopRecognizer();
    }

    public String recoInkData(int nDataLen, boolean bAsync, boolean bFlipY, boolean bSort) {
        return recognizeInkData(nDataLen, bAsync, bFlipY, bSort);
    }

    String userDictTemplate = "WritePad_User%s.dct";
    String learnerTemplate = "WritePad_Stat%s.lrn";
    String correctorTemplate = "WritePad_Corr%s.cwl";

    public int recoInit(String sDir, byte[] letterGroupStates) {
        String langAbbreviation = "";
        String userDict = String.format(userDictTemplate, langAbbreviation);
        String learner = String.format(learnerTemplate, langAbbreviation);
        String corrector = String.format(correctorTemplate, langAbbreviation);

        return recognizerInit(sDir, WritePadDictionaryEnum.none.getId(), letterGroupStates, userDict, learner, corrector);
    }
}