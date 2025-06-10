function ThemeComponent(){
    var THEME = 'salon';
    var ACCESS_TOKEN = '';
    var THE_PAGE = null;
    var theSectionList = ['hero','service-sec','about-sec','gallery-sec','team-sec','pricing-sec','contact-sec','testimonial-sec','blog-sec','brand-sec'];
    this.initialize = function (theme,_the_page,ac_token) {
        THEME = theme;
        THE_PAGE = _the_page;
        ACCESS_TOKEN = ac_token;
    }
    function genBoxHtml() {
        let nonejs = (location.href.indexOf('nonejs') > -1);
        var contentHTML = [];
        contentHTML.push('<div class="fixed-bottom" id="sync-theme-component">');
        if (nonejs) {
            contentHTML.push('  <a class="btn btn-outline-primary btn-sync-theme-component">Sync Components</a>');
        } else {
            let path = location.pathname + '?nonejs=true';
            contentHTML.push('  <a class="btn btn-outline-primary" href="'+path+'">HTML page without JS</a>');
        }
        contentHTML.push('</div>');
        return contentHTML.join("")
    }
    function syncHeaderSection() {
        var theHeaders = document.getElementsByTagName('header');
        if(theHeaders == null || theHeaders.length < 1) {
            return;
        }
        var sectionid = 'header';
        var theHeader = theHeaders[0];
        var componentData = {};
        componentData.menu ={};
        componentData.menu.bmenuTop = {};
        componentData.menu.bmenuMain = {};
        var topLeftItems = [];
        $(theHeader).find('.header-links').find('a').each(function (index,ele){
           let bitem = {};
           bitem.type = 'link';
           bitem.href = $(ele).attr('href');
           bitem.label = $(ele).html();
           topLeftItems.push(bitem);
        });
        componentData.menu.bmenuTop.leftItems=topLeftItems;
        var mainLeftItems = [];
        $(theHeader).find('.main-menu > ul > li').each( function (index,eli){
            let ele = $(eli).find('a')[0];
            let bitem = {};
            bitem.type = 'link';
            bitem.href = $(ele).attr('href');
            bitem.label = $(ele).html();
            mainLeftItems.push(bitem);
        });
        componentData.menu.bmenuMain.leftItems=mainLeftItems;
        var comItem = {};
        comItem.data = componentData;
        comItem.theme = THEME;
        comItem.code = THE_PAGE+'/' + sectionid;
        comItem.status = 1;
        comItem.content = theHeader.outerHTML;
        comItem.section = sectionid;
        comItem.tags = '#'+THE_PAGE+'#'+sectionid;
        $.ajax({
            url: '/sysadmin/theme/'+THEME+'/sync-component',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(comItem),
            dataType: "json",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + ACCESS_TOKEN);
            },
            success: function(result) {

            }
        });
    }
    function syncSection(sectionid) {
        var theSection = document.getElementById(sectionid);
        if(theSection == null) {
            return;
        }
        var comItem = {};
        comItem.theme = THEME;
        comItem.code = THE_PAGE+'/'+sectionid;
        comItem.status = 1;
        comItem.content = theSection.outerHTML;
        comItem.section = sectionid;
        comItem.tags = '#'+THE_PAGE+'#'+sectionid;
        $.ajax({
            url: '/sysadmin/theme/'+THEME+'/sync-component',
            type: 'POST',
            contentType: "application/json",
            data: JSON.stringify(comItem),
            dataType: "json",
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Authorization", "Bearer " + ACCESS_TOKEN);
            },
            success: function(result) {

            }
        });
    }
    function syncThemeComponents() {
        syncHeaderSection();
        theSectionList.forEach(value  => {
            syncSection(value);
        });
    }
    this.showSyncBox = function() {
        if (!$('#sync-theme-component').length) {
            $('body').append(genBoxHtml());
            $('.btn-sync-theme-component').on('click',function(){
                syncThemeComponents();
                $(this).unbind();
                $(this).html('Sync DONE!');
            });
        }
    };
}
$(document).ready(function (){
    let path = location.pathname;
    let ss = path.split('/');
    if (ss[1] == 'static') {
        let theme = ss[2];
        let the_page = ss[3].replace('.html','');
        var THEME_COMPONENT = new ThemeComponent();
        THEME_COMPONENT.initialize(theme,the_page,'mytoken');
        THEME_COMPONENT.showSyncBox();
    }
});
