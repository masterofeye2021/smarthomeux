
## Aufbau einer View Webseite

  Die View besitzt immer den charakteristischen Aufbau wie in folgender Abbildung. 
  Dies soll sowohl möglichen Spielraum für Varianzen bieten aber auch den Aufbau stehts identisch halten.

![Aufbau einer View](AufbauView.drawio.png){html: width=75%}

### Header

  Die Header Section bietet die Möglichkeit Includes für CSS File einzubinden, neben den typischen Meta Informationen, 
  die in 

  ~~~~~~~~~~~~~~~{.html}
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>Including Bootstrap Icons in HTML</title>
  <link th:href="@{css/bootstrap.min.css}" rel="stylesheet" />
  <link th:href="@{css/custom.css}" rel="stylesheet" />  
  ~~~~~~~~~~~~~~~

### Content
  In der Content Section werden die Views eingebettet. Der Rahmen dafür wird in der Content Section des jeweiligen Layout "Nutzer" festgelegt. 
  
  Hier ein Beispiel aus der Footer Section der Index.html.   
  ~~~~~~~~~~~~~~~{.html}
  <!-- Bottom Row -->
      <div class="row border border-black mb-4">
        <div class="col-lg-1">&nbsp;</div>
        <div class="col-10">
          <div th:insert="~{fragments/landingpage/garbageview :: garbage}"></div>
        </div>
        <div class="col-lg-1">&nbsp;</div>
      </div>
  ~~~~~~~~~~~~~~~
### Footer

  Die Footer Section bietet nicht nur die Möglichkeit JS Scripte einzubinden sondern auch über Pre- und Post-Footer
  Anpassungen vorzunehmem. 

  So werden Openhab Update Events im Pre-Fooder verarbeitet.
    