<script setup lang="ts">

</script>

<template>
  <a-list
      class="demo-loadmore-list"
      :loading="initLoading"
      item-layout="horizontal"
      :data-source="list"
  >
    <template #loadMore>
      <div
          v-if="!initLoading && !loading"
          :style="{ textAlign: 'center', marginTop: '12px', height: '32px', lineHeight: '32px' }"
      >
        <a-button @click="onLoadMore">loading more</a-button>
      </div>
    </template>
    <template #renderItem="{ item }">
      <a-list-item>
        <template #actions>
          <a key="list-loadmore-edit">edit</a>
          <a key="list-loadmore-more">more</a>
        </template>
        <a-skeleton avatar :title="false" :loading="!!item.loading" active>
          <a-list-item-meta
              description="Ant Design, a design language for background applications, is refined by Ant UED Team"
          >
            <template #title>
              <a href="https://www.antdv.com/">{{ item.name.last }}</a>
            </template>
            <template #avatar>
              <a-avatar :src="item.picture.large" />
            </template>
          </a-list-item-meta>
          <div>content</div>
        </a-skeleton>
      </a-list-item>
    </template>
  </a-list>
</template>

<style scoped>

</style>