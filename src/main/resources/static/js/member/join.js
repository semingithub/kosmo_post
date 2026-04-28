const username = document.getElementById('username')
const password = document.getElementById('password')
const passwordCheck = document.getElementById('passwordCheck')
const pwdC = document.getElementById('pwdC')
const pwMsg = document.getElementById('pwMsg')
const name = document.getElementById('name')
const phone = document.getElementById('phone')
const email = document.getElementById('email')
const birth = document.getElementById('birth')
const btn = document.getElementById('btn')
const result = document.getElementById('result')

username.addEventListener('blur', function() {
    if (username.value.trim() == '') {
        username.placeholder = '아이디를 반드시 입력하세요.'
        username.value = ''
        console.log('아이디를 반드시 입력하세요.')
		result.innerText = ''
        return
    } else if (username.value.includes(' ')) {
        username.placeholder = '아이디에 공백을 포함할 수 없습니다.'
        username.value = ''
        return
    }
    console.log('start')
    fetch(`./idCheck?username=${username.value}`)
        .then(res => res.text())
        .then(res => {
            if (res.trim() === '1') {
                console.log('중복X')
                result.innerText = '사용 가능한 아이디입니다.'
            } else {
                console.log('중복O')
                result.innerText = '사용 중인 아이디입니다.'
            }
        })
    console.log('finish')
})

password.addEventListener('blur', function() {
    if (password.value.length < 6) {
        console.log('6자리 이상입력')
        password.value = null
        password.placeholder = '6자리 이상 입력하세요'
    } else {
        passwordCheck.value = ''
    }
})

password.addEventListener('focus', function() {
    pwdC.style.display = 'block'
    pwMsg.innerText = ''
})

password.addEventListener('change', function() {
    passwordCheck.value = ''
})

passwordCheck.addEventListener('blur', function() {
    if (password.value != passwordCheck.value) {
        console.log('비번틀림')
        pwMsg.innerText = '비밀번호가 틀립니다.'
        pwdC.style.display = 'none'
        passwordCheck.value = ''
    } else {
        pwMsg.innerText = '비밀번호가 확인되었습니다.'
    }
})

btn.addEventListener('click', function() {
    if (username.value.trim() == '' || password.value.trim() == '' || name.value.trim() == '' ||
        phone.value.trim() == '' || email.value.trim() == '' || birth.value.trim() == '') {
        alert('정보를 입력해주세요.')
    } else if (result.innerText.includes('중복')) {
        alert('중복된 아이디는 가입이 불가능합니다.')
    } else {
        console.log('성공')
    }
})