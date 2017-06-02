var app=angular.module('myApp',['ngResource']);
app.controller('myCtrl',['$scope','$resource',function($scope,$resource){
	$scope.getAllVendors=function(){
		$scope.vendors=$resource("http://localhost:8080/allVendors").query(function(data){return data;});
		$scope.msg="Vendors List";
	};
	
	$scope.refresh=function(){
		getAllVendors();
	};
	$scope.validateForm=function(){
		var id=document.forms["myForm"]["id"].value;
		var name=document.forms["myForm"]["name"].value;
		var category=document.forms["myForm"]["category"].value;
		 if (id == "") {
		        alert("Id must be filled out");
		        return false;
		    }
		 else if (name == "") {
		        alert("Name must be filled out");
		        return false;
		    }
		 else if (category == "") {
		        alert("Category must be filled out");
		        return false;
		    }
		 else if (id == "" && name==" ") {
		        alert("Id and Name must be filled out");
		        return false;
		    }
		
		
		
		
		
		
		
	}
	$scope.create=function(){
		Vendor=$resource("http://localhost:8080/add",
				{},
				{save:{method:'PUT',isArray:false}}
				);
		if($scope.vid==""||$scope.vname=="" || $scope.vacte==""){
			alert("Please fill the required fields");}
		else{
		var ven={};
		ven.id=$scope.vid;
		ven.name=$scope.vname;
		ven.category=$scope.vcate;
	
		Vendor.save(ven);
		$scope.msg="Added Successfully";
		$scope.vid="";
		$scope.vname="";
		$scope.vcate="";
		}
	
	};
	$scope.deleteRec=function(){
		Vendor=$resource(
				"http://localhost:8080/delete/:id",
				{},
				{save:{method:'DELETE',params:{id:'@id'}}}
				);
		Vendor.save({id:$scope.vid});

$scope.vid="";
$scope.vname="";
$scope.vcate="";
$scope.msg="Deleted Successfully";
};

$scope.update=function(){
	Vendor=$resource(
		"http://localhost:8080/update/:id",
		{},
		{save:{method:'PUT',params:{id:'@id'}}}
		);
	var ven={};
	ven.id=$scope.venid;
	ven.name=$scope.vname;
	ven.category=$scope.vcate;
	Vendor.save({id:$scope.vid},ven);
	$scope.msg="Updated Successfully";
	$scope.vid="";
	$scope.vname="";
	$scope.vcate="";
	};

	
}]);