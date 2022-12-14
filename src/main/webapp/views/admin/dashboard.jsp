<%--
  Created by IntelliJ IDEA.
  User: youcode
  Date: 31/10/2022
  Time: 14:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>Title</title>
  <script src="https://cdn.tailwindcss.com"></script>
  <script defer src="https://unpkg.com/alpinejs@3.10.2/dist/cdn.min.js"></script>
</head>
<body>
<!-- component -->
<div x-data="setup()" :class="{ 'dark': isDark }">
  <div class="min-h-screen flex flex-col flex-auto flex-shrink-0 antialiased bg-white dark:bg-gray-700 text-black dark:text-white">

    <!-- Header -->
    <div class="fixed w-full flex items-center justify-between h-14 text-white z-10">
      <div class="flex items-center justify-start md:justify-center pl-3 w-14 md:w-64 h-14 bg-blue-800 dark:bg-gray-800 border-none">
        <img class="w-7 h-7 md:w-10 md:h-10 mr-2 rounded-md overflow-hidden" src="https://therminic2018.eu/wp-content/uploads/2018/07/dummy-avatar.jpg" />
        <span class="hidden md:block">ADMIN</span>
      </div>
      <div class="flex justify-between items-center h-14 bg-blue-800 dark:bg-gray-800 header-right">
        <div class="bg-white rounded flex items-center w-full max-w-xl mr-4 p-2 shadow-sm border border-gray-200">
          <button class="outline-none focus:outline-none">
            <svg class="w-5 text-gray-600 h-5 cursor-pointer" fill="none" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" stroke="currentColor" viewBox="0 0 24 24"><path d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>
          </button>
          <input type="search" name="" id="" placeholder="Search" class="w-full pl-3 text-sm text-black outline-none focus:outline-none bg-transparent" />
        </div>
        <ul class="flex items-center">
          <li>
            <button
                    aria-hidden="true"
                    @click="toggleTheme"
                    class="group p-2 transition-colors duration-200 rounded-full shadow-md bg-blue-200 hover:bg-blue-200 dark:bg-gray-50 dark:hover:bg-gray-200 text-gray-900 focus:outline-none"
            >
              <svg
                      x-show="isDark"
                      width="24"
                      height="24"
                      class="fill-current text-gray-700 group-hover:text-gray-500 group-focus:text-gray-700 dark:text-gray-700 dark:group-hover:text-gray-500 dark:group-focus:text-gray-700"
                      xmlns="http://www.w3.org/2000/svg"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke=""
              >
                <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M11.049 2.927c.3-.921 1.603-.921 1.902 0l1.519 4.674a1 1 0 00.95.69h4.915c.969 0 1.371 1.24.588 1.81l-3.976 2.888a1 1 0 00-.363 1.118l1.518 4.674c.3.922-.755 1.688-1.538 1.118l-3.976-2.888a1 1 0 00-1.176 0l-3.976 2.888c-.783.57-1.838-.197-1.538-1.118l1.518-4.674a1 1 0 00-.363-1.118l-3.976-2.888c-.784-.57-.38-1.81.588-1.81h4.914a1 1 0 00.951-.69l1.519-4.674z"></path>
              </svg>
              <svg
                      x-show="!isDark"
                      width="24"
                      height="24"
                      class="fill-current text-gray-700 group-hover:text-gray-500 group-focus:text-gray-700 dark:text-gray-700 dark:group-hover:text-gray-500 dark:group-focus:text-gray-700"
                      xmlns="http://www.w3.org/2000/svg"
                      fill="none"
                      viewBox="0 0 24 24"
                      stroke=""
              >
                <path
                        stroke-linecap="round"
                        stroke-linejoin="round"
                        stroke-width="2"
                        d="M20.354 15.354A9 9 0 018.646 3.646 9.003 9.003 0 0012 21a9.003 9.003 0 008.354-5.646z"></path>
              </svg>
            </button>
          </li>
          <li>
            <div class="block w-px h-6 mx-3 bg-gray-400 dark:bg-gray-700"></div>
          </li>
          <li>
            <form method="post" action="logout.ad">
              <input type="hidden" name="name" value="value" />
              <button type="submit" class="inline-flex items-center mt-4 mr-4">
                            <span class="inline-flex mr-1">
                              <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 16l4-4m0 0l-4-4m4 4H7m6 4v1a3 3 0 01-3 3H6a3 3 0 01-3-3V7a3 3 0 013-3h4a3 3 0 013 3v1"></path></svg>
                            </span>
                Logout
              </button>
            </form>
          </li>
        </ul>
      </div>
    </div>
    <!-- ./Header -->

    <!-- Sidebar -->
    <div class="fixed flex flex-col top-14 left-0 w-14 hover:w-64 md:w-64 bg-blue-900 dark:bg-gray-900 h-full text-white transition-all duration-300 border-none z-10 sidebar">
      <div class="overflow-y-auto overflow-x-hidden flex flex-col justify-between flex-grow">
        <ul class="flex flex-col py-4 space-y-1">
          <li class="px-5 hidden md:block">
            <div class="flex flex-row items-center h-8">
              <div class="text-sm font-light tracking-wide text-gray-400 uppercase">Main</div>
            </div>
          </li>
          <li>
            <a href="dashboard.ad" class="relative flex flex-row items-center h-11 focus:outline-none bg-blue-800 dark:bg-gray-600  hover:text-white-800 border-l-4 border-transparent border-blue-500 dark:border-gray-800 pr-6">
                <span class="inline-flex justify-center items-center ml-4">
                  <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"></path></svg>
                </span>
              <span class="ml-2 text-sm tracking-wide truncate">Dashboard</span>
            </a>
          </li>
          <li>
            <a href="addpromo.ad" class="relative flex flex-row items-center h-11 focus:outline-none hover:bg-blue-800 dark:hover:bg-gray-600 text-white-600 hover:text-white-800 border-l-4 border-transparent hover:border-blue-500 dark:hover:border-gray-800 pr-6">
                <span class="inline-flex justify-center items-center ml-4">
                  <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="#ffffff" stroke-width="2" stroke-linecap="round" stroke-linejoin="bevel"><line x1="19" y1="5" x2="5" y2="19"></line><circle cx="6.5" cy="6.5" r="2.5"></circle><circle cx="17.5" cy="17.5" r="2.5"></circle></svg>
                </span>
              <span class="ml-2 text-sm tracking-wide truncate">Add Promo</span>
<%--              <span class="hidden md:block px-2 py-0.5 ml-auto text-xs font-medium tracking-wide text-blue-500 bg-indigo-50 rounded-full">New</span>--%>
            </a>
          </li>
          <li>
            <a href="addrespray.ad" class="relative flex flex-row items-center h-11 focus:outline-none hover:bg-blue-800 dark:hover:bg-gray-600 text-white-600 hover:text-white-800 border-l-4 border-transparent hover:border-blue-500 dark:hover:border-gray-800 pr-6">
                <span class="inline-flex justify-center items-center ml-4">
                  <svg class="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M16 7a4 4 0 11-8 0 4 4 0 018 0zM12 14a7 7 0 00-7 7h14a7 7 0 00-7-7z"></path></svg>
                </span>
              <span class="ml-2 text-sm tracking-wide truncate">Add Responsable Rayon</span>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <!-- ./Sidebar -->

    <div class="h-full ml-14 mt-14 mb-10 md:ml-64">

      <!--Store promos Table -->
      <div class="m-4">
        <h1 class="font-bold text-xl pb-4 px-4">My Store Promos</h1>
        <div class="w-full overflow-hidden rounded-lg shadow-xs">
          <div class="w-full overflow-x-auto">
            <table class="w-full">
              <thead>
              <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b dark:border-gray-700 bg-gray-50 dark:text-gray-400 dark:bg-gray-800">
                <th class="px-4 py-3">Store</th>
                <th class="px-4 py-3">Value</th>
                <%--                <th class="px-4 py-3">Value</th>--%>
                <th class="px-4 py-3">Status</th>
                <th class="px-4 py-3">Start Date</th>
                <th class="px-4 py-3">End Date</th>
                <th class="px-4 py-3">Action</th>
              </tr>
              </thead>
              <tbody class="bg-white divide-y dark:divide-gray-700 dark:bg-gray-800">
              <c:forEach items="${promos}" var="promos">

                <tr class="bg-gray-50 dark:bg-gray-800 hover:bg-gray-100 dark:hover:bg-gray-900 text-gray-700 dark:text-gray-400">
                  <td class="px-4 py-3">
                    <div class="flex items-center text-sm">
                      <div class="relative hidden w-8 h-8 mr-3 rounded-full md:block">
                        <img class="object-cover w-full h-full rounded-full" src="https://appsgeyser.io/geticon.php?widget=Marjane%20%D9%85%D8%B1%D8%AC%D8%A7%D9%86_7131104&amp;width=512" alt="" loading="lazy" />
                        <div class="absolute inset-0 rounded-full shadow-inner" aria-hidden="true"></div>
                      </div>
                      <div>
                        <p class="font-semibold">${promos.getStoreByStoreId().getStoreName()}</p>
                        <p class="text-xs text-gray-600 dark:text-gray-400">${(promos.getCategorieByCatId().getName()!=null)?promos.getCategorieByCatId().getName():promos.getSubCategorieBySubCatId().getName()}</p>

                      </div>
                    </div>
                  </td>
                  <td class="px-4 py-3 text-sm">${promos.getValue()}%</td>
                  <td class="px-4 py-3 text-xs">
                    <c:if test="${promos.getStatus() == 'pending'}">
                      <span class="px-2 py-1 font-semibold leading-tight text-yellow-700 bg-yellow-100 rounded-full dark:text-yellow-100 dark:bg-yellow-700">pending</span>
                    </c:if>
                    <c:if test="${promos.getStatus() == 'rejected'}">
                      <span class="px-2 py-1 font-semibold leading-tight text-red-700 bg-red-100 rounded-full dark:text-red-100 dark:bg-red-700">rejected</span>
                    </c:if>
                    <c:if test="${promos.getStatus() == 'accepted'}">
                      <span class="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 rounded-full dark:bg-green-700 dark:text-green-100">accepted</span>
                    </c:if>

                  </td>
                  <td class="px-4 py-3 text-sm">${promos.getDateDebut()}</td>
                  <td class="px-4 py-3 text-sm">${promos.getDateFin()}</td>
                  <td class="px-4 py-3 text-sm">
                    <form action="delete.ad" method="POST">
                      <input type="hidden" name="promoid" value="${promos.getId()}"/>
                      <button  type="submit">
                        <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="#ff0000" stroke-width="2" stroke-linecap="round" stroke-linejoin="bevel"><polyline points="3 6 5 6 21 6"></polyline><path d="M19 6v14a2 2 0 0 1-2 2H7a2 2 0 0 1-2-2V6m3 0V4a2 2 0 0 1 2-2h4a2 2 0 0 1 2 2v2"></path><line x1="10" y1="11" x2="10" y2="17"></line><line x1="14" y1="11" x2="14" y2="17"></line></svg>
                      </button>
                    </form>
                  </td>
                </tr>
              </c:forEach>

              </tbody>
            </table>
          </div>
        </div>
      </div>
      <!-- ./promos Table -->

      <!-- Social Traffic -->
<%--      <div class="m-4">--%>
<%--        <div class="flex flex-col min-w-0 mb-4 lg:mb-0 break-words bg-gray-50 dark:bg-gray-800 w-full shadow-lg rounded">--%>
<%--          <div class="relative rounded-t mb-0 px-0 border-0">--%>
<%--            <div class="flex flex-wrap items-center px-4 py-2">--%>
<%--              <div class="relative w-full max-w-full flex-grow flex-1">--%>
<%--                <h3 class="font-semibold text-base text-gray-900 dark:text-gray-50">Social Traffic / CHARTS</h3>--%>
<%--              </div>--%>
<%--              <div class="relative w-full max-w-full flex-grow flex-1 text-right">--%>
<%--                <button class="bg-blue-500 dark:bg-gray-100 text-white active:bg-blue-600 dark:text-gray-800 dark:active:text-gray-700 text-xs font-bold uppercase px-3 py-1 rounded outline-none focus:outline-none mr-1 mb-1 ease-linear transition-all duration-150" type="button">See all</button>--%>
<%--              </div>--%>
<%--            </div>--%>
<%--            <div class="block w-full overflow-x-auto">--%>
<%--              <table class="items-center w-full bg-transparent border-collapse">--%>
<%--                <thead>--%>
<%--                <tr>--%>
<%--                  <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">Referral</th>--%>
<%--                  <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">Visitors</th>--%>
<%--                  <th class="px-4 bg-gray-100 dark:bg-gray-600 text-gray-500 dark:text-gray-100 align-middle border border-solid border-gray-200 dark:border-gray-500 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left min-w-140-px"></th>--%>
<%--                </tr>--%>
<%--                </thead>--%>
<%--                <tbody>--%>
<%--                <tr class="text-gray-700 dark:text-gray-100">--%>
<%--                  <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Facebook</th>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">5,480</td>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">--%>
<%--                    <div class="flex items-center">--%>
<%--                      <span class="mr-2">70%</span>--%>
<%--                      <div class="relative w-full">--%>
<%--                        <div class="overflow-hidden h-2 text-xs flex rounded bg-blue-200">--%>
<%--                          <div style="width: 70%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-blue-600"></div>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </div>--%>
<%--                  </td>--%>
<%--                </tr>--%>
<%--                <tr class="text-gray-700 dark:text-gray-100">--%>
<%--                  <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Twitter</th>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">3,380</td>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">--%>
<%--                    <div class="flex items-center">--%>
<%--                      <span class="mr-2">40%</span>--%>
<%--                      <div class="relative w-full">--%>
<%--                        <div class="overflow-hidden h-2 text-xs flex rounded bg-blue-200">--%>
<%--                          <div style="width: 40%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-blue-500"></div>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </div>--%>
<%--                  </td>--%>
<%--                </tr>--%>
<%--                <tr class="text-gray-700 dark:text-gray-100">--%>
<%--                  <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Instagram</th>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">4,105</td>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">--%>
<%--                    <div class="flex items-center">--%>
<%--                      <span class="mr-2">45%</span>--%>
<%--                      <div class="relative w-full">--%>
<%--                        <div class="overflow-hidden h-2 text-xs flex rounded bg-pink-200">--%>
<%--                          <div style="width: 45%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-pink-500"></div>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </div>--%>
<%--                  </td>--%>
<%--                </tr>--%>
<%--                <tr class="text-gray-700 dark:text-gray-100">--%>
<%--                  <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Google</th>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">4,985</td>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">--%>
<%--                    <div class="flex items-center">--%>
<%--                      <span class="mr-2">60%</span>--%>
<%--                      <div class="relative w-full">--%>
<%--                        <div class="overflow-hidden h-2 text-xs flex rounded bg-red-200">--%>
<%--                          <div style="width: 60%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-red-500"></div>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </div>--%>
<%--                  </td>--%>
<%--                </tr>--%>
<%--                <tr class="text-gray-700 dark:text-gray-100">--%>
<%--                  <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">Linkedin</th>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">2,250</td>--%>
<%--                  <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">--%>
<%--                    <div class="flex items-center">--%>
<%--                      <span class="mr-2">30%</span>--%>
<%--                      <div class="relative w-full">--%>
<%--                        <div class="overflow-hidden h-2 text-xs flex rounded bg-blue-200">--%>
<%--                          <div style="width: 30%" class="shadow-none flex flex-col text-center whitespace-nowrap text-white justify-center bg-blue-700"></div>--%>
<%--                        </div>--%>
<%--                      </div>--%>
<%--                    </div>--%>
<%--                  </td>--%>
<%--                </tr>--%>
<%--                </tbody>--%>
<%--              </table>--%>
<%--            </div>--%>
<%--          </div>--%>
<%--        </div>--%>
<%--      </div>--%>
      <!-- ./Social Traffic -->
    </div>
  </div>
</div>

<script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.8.0/dist/alpine.min.js" defer></script>
<script>
  const setup = () => {
    const getTheme = () => {
      if (window.localStorage.getItem('dark')) {
        return JSON.parse(window.localStorage.getItem('dark'))
      }
      return !!window.matchMedia && window.matchMedia('(prefers-color-scheme: dark)').matches
    }

    const setTheme = (value) => {
      window.localStorage.setItem('dark', value)
    }

    return {
      loading: true,
      isDark: getTheme(),
      toggleTheme() {
        this.isDark = !this.isDark
        setTheme(this.isDark)
      },
    }
  }
</script>
<style>
  /* Compiled dark classes from Tailwind */
  .dark .dark\:divide-gray-700 > :not([hidden]) ~ :not([hidden]) {
    border-color: rgba(55, 65, 81);
  }
  .dark .dark\:bg-gray-50 {
    background-color: rgba(249, 250, 251);
  }
  .dark .dark\:bg-gray-100 {
    background-color: rgba(243, 244, 246);
  }
  .dark .dark\:bg-gray-600 {
    background-color: rgba(75, 85, 99);
  }
  .dark .dark\:bg-gray-700 {
    background-color: rgba(55, 65, 81);
  }
  .dark .dark\:bg-gray-800 {
    background-color: rgba(31, 41, 55);
  }
  .dark .dark\:bg-gray-900 {
    background-color: rgba(17, 24, 39);
  }
  .dark .dark\:bg-red-700 {
    background-color: rgba(185, 28, 28);
  }
  .dark .dark\:bg-green-700 {
    background-color: rgba(4, 120, 87);
  }
  .dark .dark\:hover\:bg-gray-200:hover {
    background-color: rgba(229, 231, 235);
  }
  .dark .dark\:hover\:bg-gray-600:hover {
    background-color: rgba(75, 85, 99);
  }
  .dark .dark\:hover\:bg-gray-700:hover {
    background-color: rgba(55, 65, 81);
  }
  .dark .dark\:hover\:bg-gray-900:hover {
    background-color: rgba(17, 24, 39);
  }
  .dark .dark\:border-gray-100 {
    border-color: rgba(243, 244, 246);
  }
  .dark .dark\:border-gray-400 {
    border-color: rgba(156, 163, 175);
  }
  .dark .dark\:border-gray-500 {
    border-color: rgba(107, 114, 128);
  }
  .dark .dark\:border-gray-600 {
    border-color: rgba(75, 85, 99);
  }
  .dark .dark\:border-gray-700 {
    border-color: rgba(55, 65, 81);
  }
  .dark .dark\:border-gray-900 {
    border-color: rgba(17, 24, 39);
  }
  .dark .dark\:hover\:border-gray-800:hover {
    border-color: rgba(31, 41, 55);
  }
  .dark .dark\:text-white {
    color: rgba(255, 255, 255);
  }
  .dark .dark\:text-gray-50 {
    color: rgba(249, 250, 251);
  }
  .dark .dark\:text-gray-100 {
    color: rgba(243, 244, 246);
  }
  .dark .dark\:text-gray-200 {
    color: rgba(229, 231, 235);
  }
  .dark .dark\:text-gray-400 {
    color: rgba(156, 163, 175);
  }
  .dark .dark\:text-gray-500 {
    color: rgba(107, 114, 128);
  }
  .dark .dark\:text-gray-700 {
    color: rgba(55, 65, 81);
  }
  .dark .dark\:text-gray-800 {
    color: rgba(31, 41, 55);
  }
  .dark .dark\:text-red-100 {
    color: rgba(254, 226, 226);
  }
  .dark .dark\:text-green-100 {
    color: rgba(209, 250, 229);
  }
  .dark .dark\:text-blue-400 {
    color: rgba(96, 165, 250);
  }
  .dark .group:hover .dark\:group-hover\:text-gray-500 {
    color: rgba(107, 114, 128);
  }
  .dark .group:focus .dark\:group-focus\:text-gray-700 {
    color: rgba(55, 65, 81);
  }
  .dark .dark\:hover\:text-gray-100:hover {
    color: rgba(243, 244, 246);
  }
  .dark .dark\:hover\:text-blue-500:hover {
    color: rgba(59, 130, 246);
  }

  /* Custom style */
  .header-right {
    width: calc(100% - 3.5rem);
  }
  .sidebar:hover {
    width: 16rem;
  }
  @media only screen and (min-width: 768px) {
    .header-right {
      width: calc(100% - 16rem);
    }
  }
</style>

</body>
</html>
