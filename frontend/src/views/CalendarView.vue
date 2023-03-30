<template>
  <div class="index-page" @click="hideModal">
    <div id="calendar"></div>
    
    <div class="modal" tabindex="-1" role="dialog">
      <div class="modal-dialog" role="document">
        <div class="modal-content">
          <div class="modal-header">
            <h5 class="modal-title">{{ clickedDate }}</h5>
            <button type="button" class="close" aria-label="Close" @click="hideModal">
              <span aria-hidden="true">&times;</span>
            </button>
          </div>
          <div class="modal-body" >
            <p v-for="content, index in clickedDateContent" v-bind:key="index" v-bind:style="{color: content.textColor, backgroundColor : content.color}">{{ content.title }}{{ content.color }}</p>
            <router-link :to="{path: '/diary', query: {diary_date: clickedDate}}">Write diary</router-link>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import { ref, onMounted, onUnmounted, watch } from 'vue';
import { getDiaryList } from '@/services/DiaryService';
import { Calendar } from '@fullcalendar/core';
import dayGridPlugin from '@fullcalendar/daygrid'
import interactionPlugin from '@fullcalendar/interaction'
import bootstrapPlugin from '@fullcalendar/bootstrap';
import $ from 'jquery'
import '@fortawesome/fontawesome-free/css/all.css';

export default {
  name: "CalendarView",
  setup() {
    const calendar = ref(null);
    const clickedDate = ref(null);
    const clickedDateContent = ref(null);
    
    const diaryList = ref([]);
    

    const modalOpen = ref(false);

    const eventSources = ref([
      {
        events: [
          { // this object will be "parsed" into an Event Object
            title: 'The Title', // a property!
            start: '2023-02-28', // a property!
            groupId: 'diary',
            id: 100
          },
          // ...
        ],
        color: 'blue',     // an option!
        textColor: 'white'
      }
    ]);

    const renderCalendar = (el) => {
      const calendarObj = new Calendar(el, {
        selectable: false, // enable day selection
        // add a day click event handler that shows a modal window
        dateClick: function(info) {
          clickedDate.value = info.dateStr;
          modalOpen.value = true;
          const contents = [];
          eventSources.value.forEach((el1) => {
            el1.events.forEach((el2) => {
              if(el2.start == info.dateStr){
                contents.push({
                  title : el2.title,
                  color : el1.color,
                  textColor : el1.textColor,
                });
              }
            })
          });
          clickedDateContent.value = contents;
        },
        plugins: [ dayGridPlugin, interactionPlugin, bootstrapPlugin],
        initialView: 'dayGridMonth',
        themeSystem: 'bootstrap',
        height: 700,
        contentHeight: 10,
        aspectRatio: 0.5,
        eventSources: eventSources.value,
        dayMaxEventRows: true, // for all non-TimeGrid views
        views: {
          timeGrid: {
            dayMaxEventRows: 6 // adjust to 6 only for timeGridWeek/timeGridDay
          }
        },
        // calendarOptions
        eventClick: function(info) {
          console.log(info.dateStr);
          
        },
      })
      calendarObj.render();
    }

    const showModal = () => {
      modalOpen.value = true;
    };

    const hideModal = () => {
      modalOpen.value = false;
    };

    const closeModal = (e) => {
      if (modalOpen.value && !e.target.closest('.modal')) {
        modalOpen.value = false;
      }
    };

    onMounted(async () => {

      await getDiaryList().then((res) => {
        diaryList.value = res.data;
        diaryList.value.forEach((el) => {
          eventSources.value[0].events.push({
            title: el.title,
            start: el.diary_date,
            groupId: 'diary',
            id: el.diary_code
          });
        });
      });

      document.addEventListener('click', closeModal);

      calendar.value = document.getElementById('calendar');
      const calendarObj = new Calendar(calendar.value, {
        selectable: false, // enable day selection
        // add a day click event handler that shows a modal window
        dateClick: function(info) {
          clickedDate.value = info.dateStr;
          modalOpen.value = true;
        },
        plugins: [ dayGridPlugin, interactionPlugin, bootstrapPlugin],
        initialView: 'dayGridMonth',
        themeSystem: 'bootstrap',
        height: 700,
        contentHeight: 10,
        aspectRatio: 0.5,
        eventSources: eventSources.value,
        dayMaxEventRows: true, // for all non-TimeGrid views
        views: {
          timeGrid: {
            dayMaxEventRows: 6 // adjust to 6 only for timeGridWeek/timeGridDay
          }
        },
        // calendarOptions
        eventClick: function(info) {
          console.log(info.dateStr);
          
        },
      })
      calendarObj.render();
    });

    onUnmounted(() => {
      document.removeEventListener('click', closeModal);
    });

    watch(() => {
      if(calendar.value != null) renderCalendar(calendar.value);
    })

    return {
      calendar,
      renderCalendar,
      clickedDate,
      clickedDateContent,
      modalOpen,
      showModal,
      hideModal,
      closeModal,
    }
  },
  watch : {
    modalOpen(newValue){
      if(newValue) $(".modal").show();
      else $('.modal').hide();
    }
  }
}
</script>
<style scoped>
.modal{
  top : 300px;
}
</style> 