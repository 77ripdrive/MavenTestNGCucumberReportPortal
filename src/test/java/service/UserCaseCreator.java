package service;

import model.UserCase;

public class UserCaseCreator {

//    public static final String TESTDATA_USER_NAME = "testdata.user.name";
//    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
//
//    public static User withCredentialsFromProperty(){
//        return new User(TestDataReader.getTestData(TESTDATA_USER_NAME),
//                TestDataReader.getTestData(TESTDATA_USER_PASSWORD));
//    }

    public static final String NUMBER_OF_INCTANCE="numberOfInstance";
    public static final String WHAT_INSTANCE_FOR="whatInstunceFor";
    public static final String SOFTWARE="softWare";
    public static final String VM_CLASS="vMClass";
    public static final String INSTANCE_TYPE="instanceType";
    public static final String ADD_GPY="addGPy";
    public static final String NUMBER_GPU="numberGPU";
    public static final String GPU_TYPE="gPUType";
    public static final String LOCAL_SDD="localSSD";
    public static final String DATA_CENTER_LOCATION="dataCenterLocation";
    public static final String COMMITED_USAGE="commitedUsage";

    public static UserCase withCredentialsFromProperty(){
        return new UserCase(TestDataReader.getTestData(NUMBER_OF_INCTANCE),
                TestDataReader.getTestData(WHAT_INSTANCE_FOR),TestDataReader.getTestData(SOFTWARE),
                TestDataReader.getTestData(VM_CLASS),TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(ADD_GPY),TestDataReader.getTestData(NUMBER_GPU),
                TestDataReader.getTestData(GPU_TYPE),TestDataReader.getTestData(LOCAL_SDD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION), TestDataReader.getTestData(COMMITED_USAGE));

    }


}
