function login(){
    fetch("http://localhost:8080/login",{
        method: "POST",
        headers: {"content-Type":"application/json"},
        body: JSON.stringify({
            username:username.value,
            password:password.value
        })
    })
    .then(res=>{
        
        if(res.status===401){
            alert("invalid User");
            return;
        }
        
         return res.json();
       
    })
    .then((data)=>{localStorage.setItem("role",data.role);
        
        window.location="dashboard.html";
        
    }); 
}
function showTablesByName(){
    var tbody=document.querySelector("tbody")
    tbody.innerHTML="";
    fetch ("http://localhost:8080/students/name",{
     method: "POST",
        headers: {"content-Type":"application/json"},
        body: JSON.stringify({
            sname:sname.value
        })
}).then(res=> res.json())
.then(data=>{
    renderTables(data);
})
document.getElementById("clear").style.display="";
}
function showTables(){
    
    var tbody=document.querySelector("tbody")
     tbody.innerHTML="";
    fetch ("http://localhost:8080/students")
    .then(res=>res.json())
    .then(data=>{
        renderTables(data);
        
    })
    document.getElementById("clear").style.display="none";
}
function renderTables(data){
    let tbody=document.querySelector("tbody");
    data.forEach(student => {
            var rows=`
        <tr> <td> ${student.rno}</td>
        <td> ${student.sname}</td>
        <td> ${student.dept}</td>
        <td> ${student.email}</td> </tr>
        `
            tbody.innerHTML+=rows;
        });

}
function add(){
    fetch ("http://localhost:8080/students",{
     method: "POST",
        headers: {"content-Type":"application/json"},
        body: JSON.stringify({
            rno:rno.value,
            sname:sname.value,
            dept:dept.value,
            email:email.value
        })
})
.then(res=>res.text())
.then(data=>{
    alert(data)
})
rno.value="";
sname.value="";
dept.value="";
email.value="";
}
function update(){ 
    var r=localStorage.getItem("role").toLowerCase();
    console.log(r)
    fetch ("http://localhost:8080/students/update",{
     method: "PUT",
        headers: {"content-Type":"application/json"},
        body: JSON.stringify({
            student:{ rno:rno.value,
            sname:sname.value,
            dept:dept.value,
            email:email.value},
            role:r
        
        })
})
.then(res=>res.text())
.then((data)=>
    alert(data))
rno.value="";
sname.value="";
dept.value="";
email.value="";}

function addUser(){
    var r=localStorage.getItem("role").toLowerCase();
    console.log(uname.value);
     fetch ("http://localhost:8080/addUser",{
     method: "POST",
        headers: {"content-Type":"application/json"},
        body: JSON.stringify({
            user:{ 
            username:uname.value,
            rno:urno.value,
            password:password.value,
            role:urole.value},
            role:r
        
        })
})
.then(res=> res.text())
.then(data=>alert(data))
urno.value="";
uname.value="";
password.value="";

}

function del(){var r=localStorage.getItem("role").toLowerCase();
    console.log(r)
    fetch ("http://localhost:8080/students/delete",{
     method: "DELETE",
        headers: {"content-Type":"application/json"},
        body: JSON.stringify({
           
            role:r,
            studentId:rno.value
        
        })
})
.then(res=>res.text())
.then((data)=>
    alert(data))}