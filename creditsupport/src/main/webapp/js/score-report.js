$(document).ready(function () {

  $("#score-report").load("/creditsupport/company-figure/queryCompScore",{regId: regId, compName: compName, algorithmType: algorithmType});

});