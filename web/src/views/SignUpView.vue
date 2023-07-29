<script setup lang="ts">

import {reactive} from "vue";

const signUp = reactive({
		nickname : '',
		password: ''
})

const callSignUpApi = () => {
    alert(`${signUp.nickname} / ${signUp.password}`);
}

</script>

<template>
	<div class="container">
			<input type="text" class="id" v-model="signUp.nickname" placeholder="닉네임을 입력해주세요"/>
			<input type="password" class="password" v-model="signUp.password" placeholder="비밀번호를 입력해주세요"/>
			<button @click="callSignUpApi">회원가입</button>
	</div>
</template>

<style scoped>
.container {
	display: flex;
	flex-direction: column;
	align-items: center;
}

.container * {
	width: 200px;
	height: 30px;
	margin: 5px;
}
.container button {
	outline: 0;
	border: 0;
}

</style>