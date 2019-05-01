Feature: Estimate Calculator


  Background:
    Given I open CloudeGoogle page
    And I open Products page
    And I open Pricing page
    And I open Calculator page

  Scenario Outline : Google Cloud calculation

    When I filled the field <numberOfInstance>,<whatInstunceFor>,<softWare>,<vMClass>,<instanceType>

    Examples:
      | numberOfInstance | whatInstunceFor | softWare                                                        |
      |      4           |     none        |  Free:_Debian,_CentOS,_CoreOS,_Ubuntu,_or_other_User_Provided_OS|

    And I filled the field <vMClass>,<instanceType>,<numberGPU>,<gPUType>

    Examples:
   | vMClass | instanceType                         | numberGPU |gPUType          |
   |Regular  |CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8|     1     |NVIDIA_Tesla_V100|

    And I filled the field <localSSD>,<dataCenterLocation>,<commitedUsage>

    Examples:
      |localSSD|dataCenterLocation      |commitedUsage|
      |2x375_GB|Frankfurt_(europe-west3)|   1_Year    |

