function login() {
    //console.log('in Login method');
    var loginDetails = {};
    loginDetails["userName"] = document.getElementById("username").value;
    loginDetails["userPassword"] = document.getElementById("password").value;
    var json = JSON.stringify(loginDetails);
    let request = new XMLHttpRequest();
    request.open('POST' , 'http://localhost:8080/api/login');
    request.setRequestHeader('Content-type','application/json');
    //request.setRequestHeader("token",sessionStorage.getItem("token"));
    request.send(json);

    request.onload = function () {
        if (this.status === 200){
            var response = JSON.parse(this.response);
            sessionStorage.setItem("token",response.token);
            window.location.href = "http://localhost:8080/index.html";
        }else{
                console.log(json['message']);
        }
    }
}

function createAccount() {
    var account = {};
    account["customerId"] = document.getElementById("customerId").value;
    account["accountType"] = document.getElementById("accountType").value;
    account["balance"] = document.getElementById("depositAmount").value;
    var json = JSON.stringify(account);
    let request = new XMLHttpRequest();
    request.open('POST' , 'http://localhost:8080/api/account');
    request.setRequestHeader('Content-type','application/json');
    request.setRequestHeader("token",sessionStorage.getItem("token"));
    request.send(json);

    request.onload = function () {
        if (this.status === 200){
            window.location.href = "http://localhost:8080/index.html";
        }else{
            console.log(this.response);
        }
    }
}

function createCustomer() {
    var customer = {};
    customer["customerSSN"] =document.getElementById("ssnId").value;
    customer["customerName"] = document.getElementById("name").value;
    customer["customerAge"] = document.getElementById("age").value;
    customer["customerAddressLine1"] = document.getElementById("address1").value;
    customer["customerAddressLine2"] = document.getElementById("address2").value;
    customer["customerState"] = document.getElementById("state").value;
    customer["customerCity"] = document.getElementById("city").value;

    var json = JSON.stringify(customer);
    var request = new XMLHttpRequest();
    request.open('POST' , 'http://localhost:8080/api/customer');
    request.setRequestHeader('Content-type','application/json');
    request.setRequestHeader("token",sessionStorage.getItem("token"));
    request.send(json);

    request.onload = function () {
        if (this.status === 200){
            window.location.href = "http://localhost:8080/index.html";
        }else{
            console.log(json['message']);
        }
    }
}

function updateCustomer(){
    var updateCustomer = {}
    var request = new XMLHttpRequest();
    request.open('GET' , 'http://localhost:8080/api/customer/');
    request.setRequestHeader('Content-type','application/json');
    request.setRequestHeader("token",sessionStorage.getItem("token"));
    request.send(json);
}