package model;

import java.util.Objects;

public class UserCase {
  private String numberOfInstance;
  private String whatInstunceFor;
  private String softWare;
  private String vMClass;
  private String instanceType;
  private String numberGPU;
  private String gPUType;
  private String localSSD;
  private String dataCenterLocation;
  private String commitedUsage;


    public UserCase(String numberOfInstance,
                    String whatInstunceFor,
                    String softWare,
                    String vMClass,
                    String instanceType,
                    String numberGPU,
                    String gPUType,
                    String localSSD,
                    String dataCenterLocation,
                    String commitedUsage ) {
        this.numberOfInstance = numberOfInstance;
        this.whatInstunceFor = whatInstunceFor;
        this.softWare=softWare;
        this.vMClass=vMClass;
        this.instanceType=instanceType;
        this.numberGPU=numberGPU;
        this.gPUType=gPUType;
        this.localSSD=localSSD;
        this.dataCenterLocation=dataCenterLocation;
        this.commitedUsage=commitedUsage;
    }


    public String getNumberOfInstance() { return numberOfInstance;  }

    public String getWhatInstunceFor() {    return whatInstunceFor;    }

    public final String getSoftWare() {     return softWare;    }

    public final String getvMClass() {      return vMClass;    }

    public final String getInstanceType() {  return instanceType; }

    public final String getNumberGPU() {    return numberGPU;   }

    public final String getgPUType() {    return gPUType;   }

    public final String getLocalSSD() {   return localSSD;   }

    public final String getDataCenterLocation() {  return dataCenterLocation;    }

    public final String getCommitedUsage() {     return commitedUsage;    }

    @Override
    public String toString() {
        return "UserCase{" +
                "numberOfInstance='" + numberOfInstance + '\'' +
                ", whatInstunceFor='" + whatInstunceFor + '\'' +
                ", softWare='" + softWare + '\'' +
                ", vMClass='" + vMClass + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", numberGPU='" + numberGPU + '\'' +
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
        return Objects.equals(getNumberOfInstance(), userCase.getNumberOfInstance()) &&
                Objects.equals(getWhatInstunceFor(), userCase.getWhatInstunceFor()) &&
                Objects.equals(getSoftWare(), userCase.getSoftWare()) &&
                Objects.equals(getvMClass(), userCase.getvMClass()) &&
                Objects.equals(getInstanceType(), userCase.getInstanceType()) &&
                Objects.equals(getNumberGPU(), userCase.getNumberGPU()) &&
                Objects.equals(getgPUType(), userCase.getgPUType()) &&
                Objects.equals(getLocalSSD(), userCase.getLocalSSD()) &&
                Objects.equals(getDataCenterLocation(), userCase.getDataCenterLocation()) &&
                Objects.equals(getCommitedUsage(), userCase.getCommitedUsage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfInstance(), getWhatInstunceFor(), getSoftWare(),
                getvMClass(), getInstanceType(), getNumberGPU(), getgPUType(), getLocalSSD(),
                getDataCenterLocation(), getCommitedUsage());
    }
}





