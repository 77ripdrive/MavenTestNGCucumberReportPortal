package service;

import model.UserCase;

public class UserCaseCreator {

    public static final String NUMBER_OF_INCTANCE="numberOfInstance",SELECT_N_OF_INSTANCE="selectNOfInstance";
    public static final String WHAT_INSTANCE_FOR="whatInstunceFor",SELECT_W_INSTANCE_FOR="selectwInstunceFor";
    public static final String SOFTWARE="softWare",SELECT_SOFT_WARE_TYPE="selectSoftWareType";
    public static final String VM_CLASS="vMClass",SELECT_TYPE_VM="selectTypeVM";
    public static final String INSTANCE_TYPE="instanceType",SELECT_INSTANCE_TYPE="selectInstanceType";
    public static final String ADD_GPY="addGPy";
    public static final String NUMBER_GPU="numberGPU",SELECT_NUMBER_GPU="selectNumberGPU";
    public static final String GPU_TYPE="gPUType",SELECT_GPU="selectGPU";
    public static final String LOCAL_SDD="localSSD",SELECT_LOCAL_SSD="selectLocalSSD";
    public static final String DATA_CENTER_LOCATION="dataCenterLocation",
            SELECT_DATA_CENTER_LOCATION="selectDadaCenterLocation";
    public static final String COMMITED_USAGE="commitedUsage",SELECT_COMMITED_USAGE="selectCommitedUsage";

    public static UserCase withCredentialsFromProperty(){
        return new UserCase(
                TestDataReader.getTestData(NUMBER_OF_INCTANCE),TestDataReader.getTestData(SELECT_N_OF_INSTANCE),
                TestDataReader.getTestData(WHAT_INSTANCE_FOR), TestDataReader.getTestData(SELECT_W_INSTANCE_FOR),
                TestDataReader.getTestData(SOFTWARE),TestDataReader.getTestData(SELECT_SOFT_WARE_TYPE),
                TestDataReader.getTestData(VM_CLASS),TestDataReader.getTestData(SELECT_TYPE_VM),
                TestDataReader.getTestData(INSTANCE_TYPE), TestDataReader.getTestData(SELECT_INSTANCE_TYPE),
                TestDataReader.getTestData(ADD_GPY),
                TestDataReader.getTestData(NUMBER_GPU),TestDataReader.getTestData(SELECT_NUMBER_GPU),
                TestDataReader.getTestData(GPU_TYPE),TestDataReader.getTestData(SELECT_GPU),
                TestDataReader.getTestData(LOCAL_SDD), TestDataReader.getTestData(SELECT_LOCAL_SSD),
                TestDataReader.getTestData(DATA_CENTER_LOCATION), TestDataReader.getTestData(SELECT_DATA_CENTER_LOCATION),
                TestDataReader.getTestData(COMMITED_USAGE), TestDataReader.getTestData(SELECT_COMMITED_USAGE));

    }


}
