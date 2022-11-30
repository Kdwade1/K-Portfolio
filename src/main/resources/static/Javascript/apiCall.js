const clientApi="";
function apiCall(){
    let client=filestack.init(clientApi)
    client.pick({
        accept:'image/*',
        maxFiles:1
    })
        .then(function(result){
            const fileData =result.filesUploaded[0];
            const fileInput=document.querySelector('#fileUpload')
            const fileInputRef=document.querySelector('#fileUploadDisplay')
            fileInput.value=fileData.url;
            fileInputRef.value=fileData.url
        })
}