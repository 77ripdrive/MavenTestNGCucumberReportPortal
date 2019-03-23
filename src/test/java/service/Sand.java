package service;

public class Sand { private final String preSelectSoftWareType="//md-option/div[text()='Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS']";
    private final String preSelectVMClass="//md-select//md-option/div[text()='Regular']";
    private final String preSelectInstanceType="//md-option[@value='CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8']/div[1]";
    private final String preSelectNumberGPU="//md-option/div[@class='md-text ng-binding' and text()='1']";
    private final String preSelectGPUType="//md-option/div[contains(text(),'NVIDIA Tesla V100')]";
    private final String preSelectlocalSSD="//md-option/div[contains(text(),'2x375 GB')]";
    private final String preSelectdataCenterLocation="//md-select-menu[@class='md-overflow']//md-option/div[contains(text(),'Frankfurt')]";

}
