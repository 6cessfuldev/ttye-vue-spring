<template>
    <div class="background">
      <div class="select-wrap">
        <div class="date-select">
          <select class="date-select__year" v-model="year">
            <option value="2023">2023</option>
            <option value="2022">2022</option>
          </select>
          <select class="date-select__month" v-model="month">
            <option value="01">1월</option>
            <option value="02">2월</option>
            <option value="03">3월</option>
            <option value="04">4월</option>
            <option value="05">5월</option>
            <option value="06">6월</option>
            <option value="07">7월</option>
            <option value="08">8월</option>
            <option value="09">9월</option>
            <option value="10">10월</option>
            <option value="11">11월</option>
            <option value="12">12월</option>
          </select>
          <button  class="date-select__button">편지 찾기</button>
        </div>
      </div>

        <div class="letter-list">
            
            <div class="letter" v-for="letter in letter_list" :key="letter.id">
                <transition name="bounce">
                <router-link :to="'/letter/'+letter.id">
                    <img v-if="letter.isOpen"  src="../assets/images/opencard.png" width="150">
                    <img v-else class="vibration" src="../assets/images/closecard.png" width="150">
                </router-link>
                </transition>
                <p>{{ letter.date }}</p>
            </div>
            
        </div>
    </div>
</template>

<script>
import { useRouter} from 'vue-router'
import { ref, onMounted } from 'vue';
// import axios from 'axios'

export default {
    name: "LetterBoxView",
    setup () {
      
      const today = new Date();
      const currentYear = ref(today.getFullYear());
      const currentMonth = ref(String(today.getMonth() + 1).padStart(2, '0'));

      const years = ref([]);
      const months = ref([
        { name: '1월', value: '01' },
        { name: '2월', value: '02' },
        { name: '3월', value: '03' },
        { name: '4월', value: '04' },
        { name: '5월', value: '05' },
        { name: '6월', value: '06' },
        { name: '7월', value: '07' },
        { name: '8월', value: '08' },
        { name: '9월', value: '09' },
        { name: '10월', value: '10' },
        { name: '11월', value: '11' },
        { name: '12월', value: '12' },
      ]);

        const router = useRouter()
        const letter_list = [
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : false,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : true,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : false,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : true,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : false,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : true,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : false,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : true,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : false,
            },
            {
            id: 1,
            title : "안뇽",
            content : "배고파",
            date : "2023-03-12",
            isOpen : true,
            },
        ];

    onMounted ( () => {
      const currentYearValue = currentYear.value;
      const yearsArray = [];
      for (let i = currentYearValue; i > currentYearValue - 10; i--) {
        yearsArray.push(i);
      }
      years.value = yearsArray;
    })

        return {
          years,
          months,
          year: currentYear,
          month: currentMonth,
          router,
          letter_list
        }
    },
}
</script>

<style scoped>
.vibration {
  animation: vibration 0.1s infinite;
}
@keyframes vibration {
  from {
    transform: rotate(1deg);
  }
  to {
    transform: rotate(-1deg);
  }
}

.letter-list{
    display: flex;
    flex-wrap: wrap;
}
.letter{
  margin: 10px;
  display: flex;
  flex-direction: column;
  justify-content: flex-end;
  align-items: center;
}

.bounce-enter-active {
  animation: bounce-in 0.5s;
}
.bounce-leave-active {
  animation: bounce-in 0.5s reverse;
}
@keyframes bounce-in {
  0% {
    transform: scale(0);
  }
  50% {
    transform: scale(1.25);
  }
  100% {
    transform: scale(1);
  }
}

.select-wrap{
  display: flex;
  justify-content: center;
  height: 100px;
}

.date-select {
  display: flex;
  align-items: center;
  font-family: sans-serif;
  color: #333;
}

.date-select__year,
.date-select__month,
.date-select__button {
  font-size: 1rem;
  font-weight: bold;
  padding: 0.5rem;
  border: 2px solid #999;
  border-radius: 5px;
  appearance: none;
  background-color: transparent;
}

.date-select__year {
  margin-right: 0.5rem;
}

.date-select__month {
  margin-right: 0.5rem;
}

.date-select__button{
  margin-right: 0.5rem;
}

.date-select__year:focus,
.date-select__month:focus,
.date-select__button:focus {
  outline: none;
  box-shadow: 0 0 5px rgba(0, 0, 0, 0.2);
}

.date-select__year option,
.date-select__month option {
  font-size: 1rem;
  font-weight: bold;
}

</style>