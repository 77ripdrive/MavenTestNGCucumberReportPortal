package model;

import java.util.Objects;

public class UserCase {
  private String numberOfInstance;
  private String whatInstunceFor;
  private String softWare;
  private String vMClass;
  private String instanceType;
  private String addGPy;
  private String numberGPU;
  private String gPUType;
  private String localSSD;
  private String dataCenterLocation;
  private String commitedUsage;


    public UserCase(String numberOfInstance,String whatInstunceFor,String softWare,String vMClass,
                    String instanceType,String addGPy,String numberGPU,String gPUType,String localSSD,
                    String dataCenterLocation,String commitedUsage ) {
        this.numberOfInstance = numberOfInstance;
        this.whatInstunceFor = whatInstunceFor;
        this.softWare=softWare;
        this.vMClass=vMClass;
        this.instanceType=instanceType;
        this.addGPy=addGPy;
        this.numberGPU=numberGPU;
        this.gPUType=gPUType;
        this.localSSD=localSSD;
        this.dataCenterLocation=dataCenterLocation;
        this.commitedUsage=commitedUsage;
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

    @Override
    public String toString() {
        return "UserCase{" +
                "numberOfInstance=" + numberOfInstance +
                ", whatInstunceFor='" + whatInstunceFor + '\'' +
                ", softWare='" + softWare + '\'' +
                ", vMClass='" + vMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", addGPy='" + addGPy + '\'' +
                ", numberGPU=" + numberGPU +
                ", gPUType='" + gPUType + '\'' +
                ", localSSD='" + localSSD + '\'' +
                ", dataCenterLocation='" + dataCenterLocation + '\'' +
                ", commitedUsage='" + commitedUsage + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCase userCase = (UserCase) o;
        return getNumberOfInstance() == userCase.getNumberOfInstance() &&
                getNumberGPU() == userCase.getNumberGPU() &&
                getWhatInstunceFor().equals(userCase.getWhatInstunceFor()) &&
                getSoftWare().equals(userCase.getSoftWare()) &&
                getvMClass().equals(userCase.getvMClass()) &&
                getInstanceType().equals(userCase.getInstanceType()) &&
                getAddGPy().equals(userCase.getAddGPy()) &&
                getgPUType().equals(userCase.getgPUType()) &&
                getLocalSSD().equals(userCase.getLocalSSD()) &&
                getDataCenterLocation().equals(userCase.getDataCenterLocation()) &&
                getCommitedUsage().equals(userCase.getCommitedUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstance(), getWhatInstunceFor(), getSoftWare(), getvMClass(),
                getInstanceType(), getAddGPy(), getNumberGPU(), getgPUType(), getLocalSSD(),
                getDataCenterLocation(), getCommitedUsage());
    }
}





