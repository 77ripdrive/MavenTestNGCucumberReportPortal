package model;

import java.util.Objects;

public class UserCase {
  private String numberOfInstance,selectNOfInstance;
  private String whatInstunceFor,selectwInstunceFor;
  private String softWare,selectSoftWareType;
  private String vMClass,selectTypeVM;
  private String instanceType,selectInstanceType;
  private String addGPy;
  private String numberGPU,selectNumberGPU;
  private String gPUType,selectGPU;
  private String localSSD,selectLocalSSD;
  private String dataCenterLocation,selectDadaCenterLocation;
  private String commitedUsage,selectCommitedUsage;


    public UserCase(String numberOfInstance,String selectNOfInstance,
                    String whatInstunceFor,String selectwInstunceFor,
                    String softWare,String selectSoftWareType,
                    String vMClass,String selectTypeVM,
                    String instanceType,String selectInstanceType,
                    String addGPy,
                    String numberGPU,String selectNumberGPU,
                    String gPUType,String selectGPU,
                    String localSSD,String selectLocalSSD,
                    String dataCenterLocation,String selectDadaCenterLocation,
                    String commitedUsage,String selectCommitedUsage ) {
        this.numberOfInstance = numberOfInstance; this.selectNOfInstance=selectNOfInstance;
        this.whatInstunceFor = whatInstunceFor;this.selectwInstunceFor=selectwInstunceFor;
        this.softWare=softWare;this.selectSoftWareType=selectSoftWareType;
        this.vMClass=vMClass;this.selectTypeVM=selectTypeVM;
        this.instanceType=instanceType;this.selectInstanceType=selectInstanceType;
        this.addGPy=addGPy;
        this.numberGPU=numberGPU;this.selectNumberGPU=selectNumberGPU;
        this.gPUType=gPUType;this.selectGPU=selectGPU;
        this.localSSD=localSSD;this.selectLocalSSD=selectLocalSSD;
        this.dataCenterLocation=dataCenterLocation;this.selectDadaCenterLocation=selectDadaCenterLocation;
        this.commitedUsage=commitedUsage;this.selectCommitedUsage=selectCommitedUsage;
    }


    public String getNumberOfInstance() { return numberOfInstance;  }

    public String getWhatInstunceFor() {    return whatInstunceFor;    }

    public String getSoftWare() {     return softWare;    }

    public String getvMClass() {      return vMClass;    }

    public String getInstanceType() {  return instanceType; }
    public String getAddGPy() {    return addGPy;   }

    public String getNumberGPU() {    return numberGPU;   }

    public String getgPUType() {    return gPUType;   }

    public String getLocalSSD() {   return localSSD;   }

    public String getDataCenterLocation() {  return dataCenterLocation;    }

    public String getCommitedUsage() {     return commitedUsage;    }

    public String getSelectNOfInstance() {   return selectNOfInstance;    }

    public String getSelectwInstunceFor() {  return selectwInstunceFor;    }

    public String getSelectSoftWareType() {   return selectSoftWareType;    }

    public String getSelectTypeVM() {   return selectTypeVM;    }

    public String getSelectInstanceType() {  return selectInstanceType;    }

    public String getSelectNumberGPU() {   return selectNumberGPU;    }

    public String getSelectGPU() {     return selectGPU;   }

    public String getSelectLocalSSD() {  return selectLocalSSD;   }

    public String getSelectDadaCenterLocation() {   return selectDadaCenterLocation;    }

    public String getSelectCommitedUsage() {    return selectCommitedUsage;    }

    @Override
    public String toString() {
        return "UserCase{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", selectNOfInstance='" + selectNOfInstance + '\'' +
                ", whatInstunceFor='" + whatInstunceFor + '\'' +
                ", selectwInstunceFor='" + selectwInstunceFor + '\'' +
                ", softWare='" + softWare + '\'' +
                ", selectSoftWareType='" + selectSoftWareType + '\'' +
                ", vMClass='" + vMClass + '\'' +
                ", selectTypeVM='" + selectTypeVM + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", selectInstanceType='" + selectInstanceType + '\'' +
                ", addGPy='" + addGPy + '\'' +
                ", numberGPU='" + numberGPU + '\'' +
                ", selectNumberGPU='" + selectNumberGPU + '\'' +
                ", gPUType='" + gPUType + '\'' +
                ", selectGPU='" + selectGPU + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", selectLocalSSD='" + selectLocalSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", selectDadaCenterLocation='" + selectDadaCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                ", selectCommitedUsage='" + selectCommitedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCase userCase = (UserCase) o;
        return getNumberOfInstance().equals(userCase.getNumberOfInstance()) &&
                getSelectNOfInstance().equals(userCase.getSelectNOfInstance()) &&
                getWhatInstunceFor().equals(userCase.getWhatInstunceFor()) &&
                getSelectwInstunceFor().equals(userCase.getSelectwInstunceFor()) &&
                getSoftWare().equals(userCase.getSoftWare()) &&
                getSelectSoftWareType().equals(userCase.getSelectSoftWareType()) &&
                getvMClass().equals(userCase.getvMClass()) &&
                getSelectTypeVM().equals(userCase.getSelectTypeVM()) &&
                getInstanceType().equals(userCase.getInstanceType()) &&
                getSelectInstanceType().equals(userCase.getSelectInstanceType()) &&
                getAddGPy().equals(userCase.getAddGPy()) &&
                getNumberGPU().equals(userCase.getNumberGPU()) &&
                getSelectNumberGPU().equals(userCase.getSelectNumberGPU()) &&
                getgPUType().equals(userCase.getgPUType()) &&
                getSelectGPU().equals(userCase.getSelectGPU()) &&
                getLocalSSD().equals(userCase.getLocalSSD()) &&
                getSelectLocalSSD().equals(userCase.getSelectLocalSSD()) &&
                getDataCenterLocation().equals(userCase.getDataCenterLocation()) &&
                getSelectDadaCenterLocation().equals(userCase.getSelectDadaCenterLocation()) &&
                getCommitedUsage().equals(userCase.getCommitedUsage()) &&
                getSelectCommitedUsage().equals(userCase.getSelectCommitedUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstance(), getSelectNOfInstance(), getWhatInstunceFor(),
                getSelectwInstunceFor(), getSoftWare(), getSelectSoftWareType(), getvMClass(),
                getSelectTypeVM(), getInstanceType(), getSelectInstanceType(), getAddGPy(),
                getNumberGPU(), getSelectNumberGPU(), getgPUType(), getSelectGPU(), getLocalSSD(),
                getSelectLocalSSD(), getDataCenterLocation(), getSelectDadaCenterLocation(),
                getCommitedUsage(), getSelectCommitedUsage());
    }
}





