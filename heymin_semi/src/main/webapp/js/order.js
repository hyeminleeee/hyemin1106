
document.getElementById('btn_post_search').addEventListener('click', function() {
    new daum.Postcode({
        oncomplete: function(data) {
            var postcode = data.zonecode; // 우편번호
            var address = data.address; // 기본 주소

            document.getElementById('postcode').value = postcode;
            document.getElementById('address').value = address;
            document.getElementById('detailAddress').focus();
        }
    }).open();
});



