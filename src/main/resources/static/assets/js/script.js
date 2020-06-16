function login() {
    console.log('in Login method');
    var loginDetails = {};
    loginDetails["userName"] = document.getElementById("username").value;
    loginDetails["userPassword"] = document.getElementById("password").value;
    var json = JSON.stringify(loginDetails);
    var request = new XMLHttpRequest();
    request.open('POST' , 'http://localhost:8080/api/login');
    request.setRequestHeader('Content-type','application/json');
    request.send(json);
    request.onload = function () {
        if (this.status === 200){
            window.location.href = "http://localhost:8080/index.html";
        }else{
            // var json = JSON.parse(this.responseText);
            // if (this.status === 401)
                console.log(json['message']);
                // document.getElementById('message').innerHTML = json['error'][0]['defaultMessage'];
            // else
            //     document.getElementById('message').innerHTML = json['message'];
        }
    }
}