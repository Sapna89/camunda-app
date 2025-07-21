var obj = {
    Id: 1,
    Name: "Sapna"
}

print("userObj :: " + JSON.stringify(obj));

var obj2 = {
    Id: 4,
    Name: "Mimi"
}

execute.setVariable("userObj4", obj2)
obj;


=========================================

var userList = [
{
id: 1,
name: Steve,
email; steve@vz.com
},
{
id: 2,
name: Sapna,
email; sapna@infy.com
},
{
id: 3,
name: AAyusha,
email; aayusha@c-ops.com
}
]



userList.foreach(function(obj){
if(obj.id == userObj.id)
{
userObj.name = obj.name;
userObj.email = obj.email;
}
});