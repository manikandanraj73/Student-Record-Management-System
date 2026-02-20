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
function showTables(){
    var tbody=document.querySelector("tbody")
    fetch ("http://localhost:8080/students")
    .then(res=>res.json())
    .then(data=>{
        data.forEach(student => {
            var rows=`
        <tr> <td> ${student.rno}</td>
        <td> ${student.sname}</td>
        <td> ${student.dept}</td>
        <td> ${student.email}</td></tr>
        `
            tbody.innerHTML+=rows;
        });
        
    })
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