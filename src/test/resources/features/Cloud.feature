Feature: Estimate Calculator
  as a Google Cloud user
  I want to calculate the cost of the service with certain parameters
  and view available services

  Background:
    Given I open Cloud Google page
    And I open Products page
    And I open Pricing page
    And I open Calculator page

  Scenario Outline : Google Cloud calculation

    When I filled the field <numberOfInstance>,<whatInstunceFor>,<softWare>
    Examples:
      | numberOfInstance | whatInstunceFor | softWare                                                        |
      |      4           |     none        |  Free:_Debian,_CentOS,_CoreOS,_Ubuntu,_or_other_User_Provided_OS|

    And I filled the field <vMClass>,<instanceType>,<numberGPU>,<gPUType>

    Examples:
   | vMClass | instanceType                         | numberGPU |gPUType          |
   |Regular  |CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8|     1     |NVIDIA_Tesla_V100|

    And I filled the field <localSSD>,<dataCenterLocation>,<commitedUsage> and click Button to Estimate

    Examples:
      |localSSD|dataCenterLocation      |commitedUsage|
      |2x375_GB|Frankfurt_(europe-west3)|   1_Year    |

    Then I should see "Total Estimated Cost" message  equal to :Total Estimated Cost: USD 1,187.77 per 1 month



  Scenario Outline : Email from Google Cloud with certain parameters
    When I filled the field <numberOfInstance>,<whatInstunceFor>,<softWare>
    Examples:
      | numberOfInstance | whatInstunceFor | softWare                                                        |
      |      4           |     none        |  Free:_Debian,_CentOS,_CoreOS,_Ubuntu,_or_other_User_Provided_OS|

    And I filled the field <vMClass>,<instanceType>,<numberGPU>,<gPUType>

    Examples:
      | vMClass | instanceType                         | numberGPU |gPUType          |
      |Regular  |CP-COMPUTEENGINE-VMIMAGE-N1-STANDARD-8|     1     |NVIDIA_Tesla_V100|

    And I filled the field <localSSD>,<dataCenterLocation>,<commitedUsage> and click Button to Estimate

    Examples:
      |localSSD|dataCenterLocation      |commitedUsage|
      |2x375_GB|Frankfurt_(europe-west3)|   1_Year    |

    And I should see "Total Estimated Cost" message  and I open emailEstimate window and open TenMinuteMailPage


