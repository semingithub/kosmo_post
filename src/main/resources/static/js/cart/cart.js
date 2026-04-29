const btn = document.getElementById('btn')

btn.addEventListener('click', () => {
    let no = btn.getAttribute('data-no')
    console.log(no)

    let p = new URLSearchParams()
    p.append('productNo', no)

    fetch('../cart/create', {
        method: 'POST',
        body: p
    })
        .then(res => res.text())
        .then(res => {
			if(res.trim() === '1'){
				if(confirm('장바구니로 이동하시겠습니까?')){
					location.href = '/cart/list'
				} 
			} else {
				alret('실패')
			}
        })
    // 등록 성공하면 장바구니로 이동할거냐? 확인 이동, 취소 그대로
})