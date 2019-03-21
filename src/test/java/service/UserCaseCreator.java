package service;

import model.UserCase;

public class UserCaseCreator {

    public static final String NUMBER_OF_INCTANCE="test.data.numberOfInstance";
    public static final String WHAT_INSTANCE_FOR="test.data.whatInstunceFor";
    public static final String SOFTWARE="test.data.softWare";
    public static final String VM_CLASS="test.data.vMClass";
    public static final String INSTANCE_TYPE="test.data.instanceType";
    public static final String NUMBER_GPU="test.data.numberGPU";
    public static final String GPU_TYPE="test.data.gPUType";
    public static final String LOCAL_SDD="test.data.localSSD";
    public static final String DATA_CENTER_LOCATION="test.data.dataCenterLocation";
    public static final String COMMITED_USAGE="test.data.commitedUsage";

    public static UserCase withCredentialsFromProperty(){
        return new UserCase(
                TestDataReader.getTestData(NUMBER_OF_INCTANCE),
                TestDataReader.getTestData(WHAT_INSTANCE_FOR),
                TestDataReader.getTestData(SOFTWARE),
                TestDataReader.getTestData(VM_CLASS),
                TestDataReader.getTestData(INSTANCE_TYPE),
                TestDataReader.getTestData(NUMBER_GPU),
                TestDataReader.getTestData(GPU_TYPE),
                TestDataReader.getTestData(LOCAL_SDD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE));
    }
}
