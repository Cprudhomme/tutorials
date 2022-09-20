 $(document).ready(function () {
    var width = 0;

    var id = setInterval(frame, 500);
    function frame() {

          if (width >= 100) {
                     console.log("task is completed"+width);
                     clearInterval(id);
                    // Process to do when the progress bar is 100% window.location.href = "completed_url";
          } else {
                     console.log(width);
                     $.ajax({
                            url: "http://localhost:8080/progress"//local URI that should be adapt to the SERVER URI
                             }).then(function(data) {//retrieves the data provided by the server
                                    $('#progressbar').css('width', data.value + '%');
                                    document.getElementById("progressbar").innerHTML = data.value * 1 + '%';
                                    width = data.value;
                                     document.getElementById("progress-content").innerHTML =data.message;
                                 });
          }
      }
});